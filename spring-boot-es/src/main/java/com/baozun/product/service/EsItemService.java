package com.baozun.product.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.githup.es.constants.ESWebStatusEnum;
import org.githup.es.constants.ResponseVo;
import org.githup.es.dao.ESRepositoryV2;
import org.githup.es.utils.ProductModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.baozun.product.customer.GetItemListbyConditionsV1Param;
import com.baozun.product.customer.PageVO;
import com.baozun.product.domain.Item;
import com.baozun.product.domain.ItemAttribute;
import com.baozun.product.domain.ItemImages;
import com.baozun.product.domain.ItemSaleAttribute;
import com.baozun.product.domain.PromotionSku;
import com.baozun.product.domain.Sku;
import com.baozun.product.domain.Skus;
import com.baozun.product.es.mapper.ItemMapper;

@Service
public class EsItemService {	
	private static final Logger log = LoggerFactory.getLogger(EsItemService.class);
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ESRepositoryV2 eSRepositoryV2;
	
	public Long queryMaxId()
	{
		return itemMapper.queryMaxId();
	}
	
	
	public Long queryItemsAndSaveToEs(Long maxId,int pageSize) 
	{		
		List<Item> itemList = itemMapper.queryItems(maxId,pageSize);
		if(!CollectionUtils.isEmpty(itemList))
		{
		List<Long> itemIds=new ArrayList<Long>();		
		for(Item item:itemList)
		{
			itemIds.add(item.getId());
		}				
		maxId=itemIds.get(itemIds.size()-1);
		//商品信息，分类信息，品牌信息
		List<ItemAttribute> queryItemAttrs = itemMapper.queryItemAttrs(itemIds);
		//将查询属性结果转换为map ，商品属性属性值
		Map<Long, ItemAttribute> queryItemAttrMaps = queryItemAttrs.stream().collect(Collectors.toMap(ItemAttribute::getItemId, a -> a,(k1,k2)->k1));		
	    //将商品转换为map
		//Map<Long, ItemV1SolrVO> itemListMpas = itemList.stream().collect(Collectors.toMap(ItemV1SolrVO::getId, a -> a,(k1,k2)->k1));
		//商品的销售属性，属性值，销售属性图片，缩率图
		List<ItemSaleAttribute> queryItemSaleAttrs = itemMapper.queryItemSaleAttrs(itemIds);
		Map<Long, ItemSaleAttribute> queryItemSaleAttrsMaps = queryItemSaleAttrs.stream().collect(Collectors.toMap(ItemSaleAttribute::getItemId, a -> a,(k1,k2)->k1));
		//商品图片
		List<ItemImages> queryItemImages = itemMapper.queryItemImages(itemIds);
		Map<Long, ItemImages> queryItemImagesMaps = queryItemImages.stream().collect(Collectors.toMap(ItemImages::getItemId, a -> a,(k1,k2)->k1));
		//商品sku信息
		List<Skus> querySkuInfo = itemMapper.querySkuInfo(itemIds);
		Map<Long, Skus> querySkuInfoMaps = querySkuInfo.stream().collect(Collectors.toMap(Skus::getItemId, a -> a,(k1,k2)->k1));
		//得到所有的skucode
		/*List<String> skuCodes=new ArrayList<String>();
		for(Skus skus:querySkuInfo)
		{
			List<Sku> skuList=skus.getSkuList();
			for(Sku sku:skuList)
			{
			 skuCodes.add(sku.getCode());
			}
		}*/
		//促销信息
		/*List<PromotionSku> queryPromotionData1 = itemMapper.queryPromotionData(skuCodes);
		List<PromotionSku> queryPromotionData2 = itemMapper.queryPromotionData(skuCodes);
		queryPromotionData1.addAll(queryPromotionData2);*/
		for(Item item:itemList)
		{			
			Long itemId=item.getId();
			item.setAttrList(queryItemAttrMaps.get(itemId).getAttributeList());
			item.setAttrSaleList(queryItemSaleAttrsMaps.get(itemId).getSaleAttributeList());
			item.setItemImageList(queryItemImagesMaps.get(itemId).getItemImageList());
			item.setSkuList(querySkuInfoMaps.get(itemId).getSkuList());
			//item.setPromotionData(queryPromotionData1);
		}
		eSRepositoryV2.addItemDataToEs(itemList);
		}
		return maxId;		 
	}
	
	public  SearchResponse queryItemByCondition(GetItemListbyConditionsV1Param request)
	{
		
		String tenantCode = request.getTenantCode();
		PageVO page = request.getPage();
		int pageNow=page.getPage();
		int size = page.getSize();
		
		
		if( StringUtils.isEmpty(tenantCode) ||StringUtils.isEmpty(page)|| StringUtils.isEmpty(pageNow) ||StringUtils.isEmpty(size)) {
    		log.info("入参不可以为空");
    		return null;
    	}
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		boolQuery.must(new QueryStringQueryBuilder(tenantCode).field("tenantCode"));
		
		return	eSRepositoryV2.searchItemDataByParam(String.valueOf(ProductModule.product), String.valueOf(ProductModule.items), boolQuery, pageNow, size);

		/*QueryBuilder qb = QueryBuilders.boolQuery()
		.must(new QueryStringQueryBuilder("1").field("active"))
		.must(QueryBuilders.boolQuery()
		    .should(QueryBuilders.matchQuery("name", "小李子"))
		    .should(QueryBuilders.matchQuery("code", 小李子"))
		);*/
	}
}

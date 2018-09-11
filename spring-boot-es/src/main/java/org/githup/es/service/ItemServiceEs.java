package org.githup.es.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.math.NumberUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.githup.es.constants.ResponseVo;
import org.githup.es.utils.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baozun.product.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ItemServiceEs {
	@Autowired
	private ESSearchService esSearchService;
	
	public ResponseVo  BuildItem(String index, String type, String id) throws Exception
	{
		
		ResponseVo rv=new ResponseVo();  
		Map<String,Item> itemsMap=new HashMap<String,Item>();
		List<String> itemCodes=new ArrayList<String>();
    	Item itemV1SolrVO=null;
    	String itemCode=null;
    	//查询商品信息
    	SearchResponse responseItems = esSearchService.searchItemsDataByParam(index, type, id);
    	SearchHit[] searchHits = responseItems.getHits().getHits();
    	long totalHits = responseItems.getHits().getTotalHits();
		for(int i = 0; i < searchHits.length; i++) {							
			JSONObject	resultObject =JSONObject.parseObject(searchHits[i].getSourceAsString());	
			 itemV1SolrVO=this.buildItemParam(resultObject);
			 itemCode=itemV1SolrVO.getCode();
			 itemsMap.put(itemCode, itemV1SolrVO);
			 itemCodes.add(itemCode);
		}
		//获取商品属性
		
		//销量
		//itemV1SolrVO.setSales(sales);
		//库存
		//inventory
		//data.add(itemV1SolrVO);
		/*rv.setData(data);
		rv.setCount(totalHits);
		rv.setCode("0");
		rv.setMessage("查询商品成功");*/
		return rv;
	}
	
	public Item  buildItemParam(JSONObject	resultObject)
	{   Item itemV1SolrVO=new Item();
		itemV1SolrVO.setCode(resultObject.getString("code"));
		itemV1SolrVO.setTenantCode(resultObject.getString("tenant_code"));
		itemV1SolrVO.setTitle(resultObject.getString("title"));
		itemV1SolrVO.setSubTitle(resultObject.getString("sub_title"));
		itemV1SolrVO.setSalePrice(NumberUtils.createBigDecimal(resultObject.getString("sale_price")));
		itemV1SolrVO.setListPrice(NumberUtils.createBigDecimal(resultObject.getString("list_price")));			
		itemV1SolrVO.setType(resultObject.getInteger("type"));
		itemV1SolrVO.setDescription(resultObject.getString("description"));
		//itemV1SolrVO.setListTime(DateUtil.SolrDateConvertDate(resultObject.getString("list_time")) );
		//itemV1SolrVO.setDelistTime(DateUtil.SolrDateConvertDate(resultObject.getString("delist_time")));
		itemV1SolrVO.setSaleStatus(resultObject.getInteger("sale_status"));
		itemV1SolrVO.setPreOrder(resultObject.getInteger("pre_order"));
		itemV1SolrVO.setSizeChart(resultObject.getString("size_chart"));
		//itemV1SolrVO.setFixedListTime(DateUtil.SolrDateConvertDate(resultObject.getString("fixed_list_time")));
		//itemV1SolrVO.setFixedDelistTime(DateUtil.SolrDateConvertDate(resultObject.getString("fixed_delist_time")));
		return itemV1SolrVO;
	}
}

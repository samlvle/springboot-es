package com.baozun.product.es.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.baozun.product.domain.Item;
import com.baozun.product.domain.ItemAttribute;
import com.baozun.product.domain.ItemImages;
import com.baozun.product.domain.ItemSaleAttribute;
import com.baozun.product.domain.PromotionSku;
import com.baozun.product.domain.Skus;

public interface ItemMapper {
   List<Item> queryItems(@Param("maxId")Long maxId,@Param("pageSize")int pageSize); 
   List<ItemAttribute> queryItemAttrs(@Param("itemIds") List<Long> itemIds);   
   List<ItemSaleAttribute> queryItemSaleAttrs(@Param("itemIds") List<Long> itemIds);   
   List<ItemImages> queryItemImages(@Param("itemIds") List<Long> itemIds);
   List<Skus> querySkuInfo(@Param("itemIds") List<Long> itemIds);    
   List<PromotionSku> queryPromotionData(@Param("skuCodes") List<String> skuCodes);  
   List<PromotionSku> queryPromotionData2(@Param("skuCodes") List<String> skuCodes);  
   Long queryMaxId();  
   
   
   
}

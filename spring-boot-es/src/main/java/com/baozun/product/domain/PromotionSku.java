package com.baozun.product.domain;
import lombok.Data;
import org.springframework.context.annotation.Description;
@Data
@Description("[对外]")
public class PromotionSku {   
	private Long id;
	
    private String skuCode;
  
    private String name;
   
    private String activityCode;
   
    private String startTime;
  
    private String endTime;
   
    private Integer state;

    //促销活动名字
    private String labelName;
    //促销后商品销售价格
    private String salePrice;
    
    private String activityName;
}

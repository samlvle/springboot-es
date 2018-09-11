package com.baozun.product.domain;
import lombok.Data;
import org.springframework.context.annotation.Description;
@Data
@Description("[对外]")
public class ItemSaleAttrImage {  
    private Long id;
    private String code;
   /* @JsonIgnore
    @JSONField(serialize = false)
    private Long itemId;*/
    //图片地址
    private String picUrl;
  /*  @JsonIgnore
    @JSONField(serialize = false)
    private Long saleAttributeId;*/
  /*  @JsonIgnore
    @JSONField(serialize = false)
    private String saleAttributeValue;*/
   /* @JsonIgnore
    @JSONField(serialize = false)*/
    private Integer position;

   // private List<ItemImageAttachSolrVO> itemImageAttachList;
    
    private Integer picOrder;//图片排序
}
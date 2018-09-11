package com.baozun.product.domain;
import lombok.Data;
import org.springframework.context.annotation.Description;
@Data
@Description("[对外]")
public class AttributeValue {  
    private Long id;  
    //属性值编码
    private String code;
    //属性值显示名
    private String attributeValueFrontName;
    private String attributeValueName;
    //属性值显示名
    private String attributeValuePicURL;       
    //前端属性树需要的字段
    private String frontName;    
    private Integer attributeIndex;//排序
    private Long attributeClassValueId;
    /*//属性值图片列表
    @JsonIgnore
    @JSONField(serialize = false)
    private List<ItemImageSolrVO> itemAttributeValueImageList;
    //属性值缩略图
    @JsonIgnore
    @JSONField(serialize = false)
    private List<ItemImageAttachSolrVO> itemAttributeValueThumbnailList;*/
    
    /*  @JsonIgnore
    @JSONField(serialize = false)
    private AttributeValueV1SolrVO parent;*/
}
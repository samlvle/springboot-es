package com.baozun.product.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Description;
import java.util.List;
@Data
@Description("[对内]")
public class AttributeValueSolrVO {
    @JsonIgnore
    @JSONField(serialize = false)
    private Long id;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long attributeValueId;
    //属性值编码
    private String code;
    //属性名字
    private String attributeValueName;
    //属性值显示名
    private String attributeValueFrontName;
    //属性值显示名
    private String attributeValuePicURL;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long attributeClassValueId;

    //前端属性树需要的字段
    private String frontName;
    
    private Integer attributeIndex;//排序

    @JsonIgnore
    @JSONField(serialize = false)
    private AttributeValueSolrVO parent;
    //属性值图片列表
    private List<ItemImageSolrVO> itemAttributeValueImageList;
    //属性值缩略图
    private List<ItemImageAttachSolrVO> itemAttributeValueThumbnailList;
}
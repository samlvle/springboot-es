package com.baozun.product.domain;
import lombok.Data;
import org.springframework.context.annotation.Description;
import java.util.List;
@Data
@Description("[对外]")
public class SalesAttribute {  
    private Long id;
    private Long itemId;
    private Long skuId;
    private String code;
    private String attributeFrontName;   
    //0,solr筛选，1，solr不筛选
    private Integer filterSign;  
    private Long attributeClassId;    
    private Integer sort;
    private String attributeName;
    //属性分类：0代表商品属性；1代表销售属性
    private Integer attributeType;
    //属性值类型：0：单选；1：多选；2：输入框
    private Integer attributeValueType;
    //是否必填：0代表必填；1代表不必填
    private Integer attributeValueMandatory;
    //是否颜色 1是 0否
    private Integer attributeColor;   
    //0 属性类，1 属性
    private Integer attributeClassFlag;
    //是否显示 0 显示 1 不显示 默认为显示
    private Integer isDisplay;   
    //属性值列表
    private List<AttributeSaleValue> attributeValueList;
    
    /*  @JsonIgnore
    @JSONField(serialize = false)
    private Long skuId;*/
}
package com.baozun.product.domain;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Description;
import java.util.List;
@Data
@Description("[对外]")
public class SkuAttributeV1SolrVO {
    @JsonIgnore
    @JSONField(serialize = false)
    private Long id;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long skuId;
    //属性编码
    private String code;
    //属性显示名
    private String attributeFrontName;
    //属性值
    private List<AttributeValueSolrVO> attributeValueList;
    
    private Integer sort;//排序
}
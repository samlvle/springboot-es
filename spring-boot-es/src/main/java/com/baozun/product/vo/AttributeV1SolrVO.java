package com.baozun.product.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Description;
import java.util.List;
@Data
@Description("[对外]")
public class AttributeV1SolrVO {
    @JsonIgnore
    @JSONField(serialize = false)
    private Long id;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long skuId;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long itemId;
    private String code;
    private String attributeFrontName;
    @JsonIgnore
    @JSONField(serialize = false)
    private Integer filterSign;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long attributeClassId;
    
    private Integer sort;

    //属性值列表
    private List<AttributeValueV1SolrVO> attributeValueList;
}
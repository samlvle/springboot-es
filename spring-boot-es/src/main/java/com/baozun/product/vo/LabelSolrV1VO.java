package com.baozun.product.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
@Data
public class LabelSolrV1VO {
    @JsonIgnore
    @JSONField(serialize = false)
    private Long id;
    private String code;
    private String frontName;
    private String description;
}
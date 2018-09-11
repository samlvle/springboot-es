package com.baozun.product.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
@Data
public class BrandSolrV1VO {
    @JsonIgnore
    @JSONField(serialize = false)
    private Long id;
    //商品编码
    private String code;
    //商品名称
    private String name;
    //商品描述
    private String description;
    //商品图片
    private String imageUrl;
    @JsonIgnore
    @JSONField(serialize = false)
    private String tenantCode;
}

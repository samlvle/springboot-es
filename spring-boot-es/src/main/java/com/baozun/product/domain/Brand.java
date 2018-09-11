package com.baozun.product.domain;
import lombok.Data;
@Data
public class Brand{
    private Long id;
    //商品编码
    private String code;
    //商品名称
    private String name;
    //商品描述
    private String description;
    //商品图片
    private String imageUrl;
    //0，有效，1无效
    private Integer enableSign;
   /* @JsonIgnore
    @JSONField(serialize = false)
    private String tenantCode;*/
}

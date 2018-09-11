package com.baozun.product.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Description;
@Data
@Description("[对外]")
public class PromotionItemV1SolrVO {
    @JsonIgnore
    @JSONField(serialize = false)
    private String skuCode;
    @JsonIgnore
    @JSONField(serialize = false)
    private String name;
    @JsonIgnore
    @JSONField(serialize = false)
    private String activityCode;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long startTime;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long endTime;
    @JsonIgnore
    @JSONField(serialize = false)
    private Integer state;

    //促销活动名字
    private String labelName;
    //促销后商品销售价格
    private Double salePrice;
}

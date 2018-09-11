package com.baozun.product.customer;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Data
@ApiModel(value="ItemFilterSolrCountParamVO",description="过滤条数对象")
public class ItemFilterSolrCountParamVO {
    private ItemFilterSolrCountParamVO parent;
    @ApiModelProperty(value="属性的关键字")
    private String key;
    @ApiModelProperty(value="属性的值")
    private String value;
}

package com.baozun.product.customer;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
@Data
@ApiModel(value="ItemFilterSolrParamVO",description="过滤条件对象")
public class ItemFilterSolrParamVO {
    private ItemFilterSolrParamVO parent;
    @ApiModelProperty(value="商品过滤条件code")
    private String code;
    @ApiModelProperty(value="商品过滤条件数量对象列表")
    private List<ItemFilterSolrCountParamVO> data;
}

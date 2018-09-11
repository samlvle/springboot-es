package com.baozun.product.customer;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Data
@ApiModel(value="ItemSortSolrParamVO",description="商品排序对象")
public class ItemSortSolrParamVO {
	@ApiModelProperty(value="属性的名称")
    private String name;
	@ApiModelProperty(value="属性的显示名称")
    private String frontName;
	@ApiModelProperty(value="排序类型（升序/降序）")
    private int sort;
}

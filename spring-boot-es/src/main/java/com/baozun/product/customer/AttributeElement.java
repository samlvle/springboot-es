package com.baozun.product.customer;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="AttributeElement",description="属性条件对象")
public class AttributeElement {
	@ApiModelProperty(value="属性值code集合")
	private List<String> AttributeCodeSublist;

}

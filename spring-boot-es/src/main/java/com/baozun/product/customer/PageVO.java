package com.baozun.product.customer;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Data
@ApiModel(value="PageVO",description="分页对象")
public class PageVO {
	@ApiModelProperty(value="第多少页")
    private int page;
	@ApiModelProperty(value="每页条数")
    private int size;
}

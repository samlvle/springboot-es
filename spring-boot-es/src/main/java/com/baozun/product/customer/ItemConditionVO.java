package com.baozun.product.customer;
import lombok.Data;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Data
@ApiModel(value="ItemConditionVO",description="商品条件对象")
public class ItemConditionVO {
	@ApiModelProperty(value="商品状态：1 上架, 2 下架")
    private Integer saleStatus;
    @ApiModelProperty(value="商品类型：0 商品、1 赠品")
    private Integer type;
    
    @ApiModelProperty(value="预售标志：0 预售 1 非预售")
	private Integer preOrder;

	@ApiModelProperty(value="商品品牌编码列表")
    private List<String> brandCode;
	
	@ApiModelProperty(value="商品价格区间最低价格")
    private Double salePriceStart;
	@ApiModelProperty(value="商品价格区间最高价格")
    private Double salePriceEnd;
	/*@ApiModelProperty(value="库存区间最低数量")
    private Integer inventoryStart;
	@ApiModelProperty(value="库存区间最高数量")
    private Integer inventoryEnd;*/

	@ApiModelProperty(value="销售属性值编码列表")
    private List<String> saleAttributeValueCodeList;

    private List<AttributeElement> attrbuteCodeList;

    @ApiModelProperty(value="分类编码列表")
    private List<String> categoryCodeList;

    private String style;//款式

    private String categoryCode;
}

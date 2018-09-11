package com.baozun.product.customer;
import lombok.Data;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Data
@ApiModel(value="GetItemListbyConditionsV1Param",description="根据搜索条件查询商品列表的请求参数对象")
public class GetItemListbyConditionsV1Param {
	@ApiModelProperty(value="租户编码",required=true)
    private String tenantCode;
	@ApiModelProperty(value="过滤条件：" +
            "\n" +
            "1, temFilterList数据元素之间，使用逻辑关系 and" +
            "\n" +
            "2, data内部，使用逻辑关系  or")
    private List<ItemFilterSolrParamVO> itemFilterList;
	@ApiModelProperty(value="排序条件")
    private List<ItemSortSolrParamVO> itemSortList;
	@ApiModelProperty(value="商品条件:" +
            "\n" +
            "1，同一层级别的不同条件是and关系，比如salePriceStart和brandCode是and关系\n" +
            "\n" +
            "2，brandCode这一类的列表参数，内部的不同brandCode是or的关系\n" +
            "\n" +
            "3，condition之间是or的关系")
    private List<ItemConditionVO> conditionList;
	@ApiModelProperty(value="例外的商品编码")
    private List<String> notIncludeSpuCodeList;
    @ApiModelProperty(value="关键字：商品title，商品描述，商品code，品类，属性/属性值front_name")
	private String keyword;
	@ApiModelProperty(value="分页条件, 可以不填写，默认为10条")
    private PageVO page;
}

package com.baozun.product.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
@Data
public class SkuV1SolrVO {
    @JsonIgnore
    @JSONField(serialize = false)
    private Long id;
    //是否可用：0 enable 1 disable
    private Integer status;
    //sku列表价格
    private BigDecimal listPrice;
    //sku销售价格
    private BigDecimal salePrice;
    private BigDecimal weight;
    //sku 编码
    private String code;
    //sku 外部编码
    private String extentionCode;
    
    private Integer isDefault;

    private Long inventory;
    private Long sales;
    //sku 库存
    private Long netqty;

    private List<SkuAttributeV1SolrVO> attrSaleList;
}

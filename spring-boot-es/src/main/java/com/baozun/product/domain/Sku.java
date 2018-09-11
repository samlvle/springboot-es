package com.baozun.product.domain;
import lombok.Data;
import java.util.List;
@Data
public class Sku {
    private Long id;
    //是否可用：0 enable 1 disable
    private Integer status;
    //sku列表价格
    private String listPrice;
    //sku销售价格
    private String salePrice;
    private String weight;
    //sku 编码
    private String code;
    //sku 外部编码
    private String extentionCode;
    
    private Integer isDefault;

    private Long inventory;
    private Long sales;
    //sku 库存
    private Long netqty;

    private String barCode;
    private List<SalesAttribute> attrSaleList;
}

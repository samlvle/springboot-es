package com.baozun.product.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ItemV1SolrVO {
    @JsonIgnore
    @JSONField(serialize = false)
    private Long id;
    //商品编码
    private String code;
    //租户ID
    private String tenantCode;
    //商品名称
    private String title;
    //商品副标题
    private String subTitle;
    //商品销售价格
    private BigDecimal salePrice;
    //商品列表价格
    private BigDecimal listPrice;
    //商品类型：0普通，1赠品
    private Integer type;
    //商品描述
    private String description;
    //上架时间
    private Date listTime;
    //下架时间
    private Date delistTime;
    //1上架；2下架'
    private Integer saleStatus;
    //销量
    private Long sales;

    private String style;

    //定时上架时间
    private Date fixedListTime;
    //定时下架时间
    private Date fixedDelistTime;
    
    //预售标志
    private Integer preOrder;

    private String sizeChart;

    //商品品牌信息
    private BrandSolrV1VO brand;

    //商品分类信息
    private List<CategoryV1SolrVO> categoryList;

    private List<ItemImageSolrVO> itemImageList;

    @JsonIgnore
    @JSONField(serialize = false)
    private List<ItemImageRegSolrVO> itemImageRegList;//销售属性对应图片

    //商品标签信息
    private List<LabelSolrV1VO> labelList;

    //商品商品属性信息
    private List<AttributeV1SolrVO> attrList;

    //商品销售属性信息
    private List<AttributeV1SolrVO> attrSaleList;

    //
    private List<SkuV1SolrVO> skuList;

    private List<PromotionItemV1SolrVO> promotionData;

    private List<RecommendItemV1SolrVO> recommendItemsList;
}

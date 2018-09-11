package com.baozun.product.domain;
import java.math.BigDecimal;
import lombok.Data;
import java.util.List;
@Data
public class Item { 
    private Long id;
    //商品编码
    private String code;
    //租户ID
    private String tenantCode;
    //属性集ID
    private Long propertySetId;  
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
    private String listTime;
    //下架时间
    private String delistTime;
    //1上架；2下架'
    private Integer saleStatus;
    //销量
    private Long sales;
    //定时上架时间
    private String fixedListTime;
    //定时下架时间
    private String fixedDelistTime;  
    //预售标志
    private Integer preOrder;
    //尺码表地址
    private String sizeChart;
    private String updateTime;
    private String createTime;
    private String logicDelete;
       
    //商品品牌信息
    private Brand brand;
    //商品分类信息
    private List<Category> categoryList;

    private List<ItemImage> itemImageList;

  /*  @JsonIgnore
    @JSONField(serialize = false)
    private List<ItemImageRegSolrVO> itemImageRegList;//销售属性对应图片
*/
    //商品标签信息
    private List<LabelSolrV1VO> labelList;

    //商品商品属性信息
    private List<Attribute> attrList;

    //商品销售属性信息
    private List<SalesAttribute> attrSaleList;

    //
    private List<Sku> skuList;

    private List<PromotionSku> promotionData;

    private List<RecommendItemV1SolrVO> recommendItemsList;
    
    /* //简介
    @JsonIgnore
    @JSONField(serialize = false)
    private String sketch;  
        //商品款式
    @JsonIgnore
    @JSONField(serialize = false)
    private String style;
    //SEO标题
    @JsonIgnore
    @JSONField(serialize = false)
    private String seoTitle;
    //SEO关键字
    @JsonIgnore
    @JSONField(serialize = false)
    private String seoKeywords;
    //SEO描述
    @JsonIgnore
    @JSONField(serialize = false)
    private String seoDescription;
    //激活开始时间
    @JsonIgnore
    @JSONField(serialize = false)
    private String activeStartTime;
    //激活结束时间
    @JsonIgnore
    @JSONField(serialize = false)
    private String activeEndTime;
    //入仓时间
    @JsonIgnore
    @JSONField(serialize = false)
    private String warehouseTime;
    //自定义url
    @JsonIgnore
    @JSONField(serialize = false)
    private String customUrl;
    //激活关键字
    @JsonIgnore
    @JSONField(serialize = false)
    private String keywords;
    
      //是否显示促销icon
    @JsonIgnore
    @JSONField(serialize = false)
    private String isShowPromotionIcon;
    //促销icon
    @JsonIgnore
    @JSONField(serialize = false)
    private String promotionIconUrl;
    @JsonIgnore
    @JSONField(serialize = false)
    private String productImgAlt;
    
    //oms商品编码(到款),也就是宝尊编码
    @JsonIgnore
    @JSONField(serialize = false)
    private String jmCode;
    //供应商商品编码(到款),也就是货号
    @JsonIgnore
    @JSONField(serialize = false)
    private String supplierSkuCode;
    */
}


package com.baozun.product.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Description;
import java.util.List;
@Data
@Description("[对外]")
public class CategoryV1SolrVO {
    @JsonIgnore
    @JSONField(serialize = false)
    private Long id;
    //分类编码
    private String code;
    //分类定义名
    private String name;
    //分类显示名
    private String frontName;
    //分类图片
    private String imageUrl;
    @JsonIgnore
    @JSONField(serialize = false)
    private String tenantCode;//租户ID
    @JsonIgnore
    @JSONField(serialize = false)
    private Long parentId;
    //分类排序
    private Integer sort;
    
    private String categoryPath;

    private List<CategoryV1SolrVO> children;
}

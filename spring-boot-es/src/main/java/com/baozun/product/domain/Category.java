package com.baozun.product.domain;
import lombok.Data;
import org.springframework.context.annotation.Description;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Data
@Description("[对外]")
public class Category {
    private Long id;
    //分类编码
    private String code;
    //分类定义名
    private String name;
    //分类显示名
    private String frontName;    
    //分类排序
    private Integer sort;   
    private String categoryPath;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long parentId;
   /* @JsonIgnore
    @JSONField(serialize = false)
    private String tenantCode;//租户ID    
   // private List<CategoryV1SolrVO> children;*/
}

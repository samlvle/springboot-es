package com.baozun.product.domain;
import lombok.Data;
import org.springframework.context.annotation.Description;
@Data
@Description("[对外]")
public class RecommendItemV1SolrVO {
    private String code;
    private String title;
}
package com.baozun.product.domain;
import lombok.Data;
import org.springframework.context.annotation.Description;
import java.util.List;
@Data
@Description("[对外]")
public class Skus{
    private Long itemId;  
    //图片列表
    private List<Sku> skuList;
}
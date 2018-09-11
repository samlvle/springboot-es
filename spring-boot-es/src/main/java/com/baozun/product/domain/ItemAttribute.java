package com.baozun.product.domain;
import lombok.Data;
import org.springframework.context.annotation.Description;
import java.util.List;
@Data
@Description("[对外]")
public class ItemAttribute{
    private Long itemId;  
    //属性列表
    private List<Attribute> attributeList;
}
package com.baozun.product.domain;
import lombok.Data;
import org.springframework.context.annotation.Description;
@Data
@Description("[对外]")
public class ItemSaleAttrImageAttach {  
    private Long id; 
    private Integer targetType;  
    private Long targetId;
    private Integer relType;
    //媒体类型：1:图片，2：视频，3：文件
    private Integer mediaType;
    //路径
    private String url;
    //缩略图顺序
    private Integer sort;

   

}

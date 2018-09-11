package com.baozun.product.domain;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Description;
@Data
@Description("[对内]")
public class ItemImageRegSolrVO {
	@JsonIgnore
	private Long id;
	private String tenantCode;
	private Long itemId;
	private Integer level;
	private String express;

	//private List<ItemImageSolrVO> itemImageList;
	private List<ItemImageAttachSolrVO> itemImageAttachList; 
}

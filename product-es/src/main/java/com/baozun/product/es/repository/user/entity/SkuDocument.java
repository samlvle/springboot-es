package com.baozun.product.es.repository.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

/**
 * 商品Document -example
 * <p>
 * Created by lijingyao on 2018/1/18 18:03.
 */
@Data
@Document(indexName = SkuDocument.INDEX, type = SkuDocument.TYPE)
public class SkuDocument {

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static final String INDEX = "skus";
    public static final String TYPE = "sku";


    public SkuDocument() {
    }

   /* public SkuDocument(Integer id, Integer catId, String name, Long price, String description) {
        this.id = id;
        this.catId = catId;
        this.name = name;
        this.price = price;
        this.description = description;
    }*/

    /**
     * 商品唯一标识
     */
    @Id
    @Field(type = FieldType.keyword)
    private Integer id;

    /**
     * 类目id
     */
    @Field(type = FieldType.Integer)
    private Integer catId;

    /**
     * 商品名称
     */
    @Field(type = FieldType.text,index = false)
    private String name;


    /**
     * 商品价格
     */
    @Field(type = FieldType.Long)
    private Long price;



    /**
     * 商品的描述
     */
    @Field(type = FieldType.text, searchAnalyzer = "ik", analyzer = "ik")
    private String description;


    @Override
    public String toString() {
        return "SkuDocument{" +
                "id='" + id + '\'' +
                ", catId=" + catId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

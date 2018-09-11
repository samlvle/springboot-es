package org.githup.es.dao;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.githup.es.utils.ProductModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.baozun.product.domain.Item;
/**
 * ES的操作数据类
 * 
 * 备注：对es的一些操作做了一些封装，抽出来一些操作，就是传统的dao层，数据服务
 * 
 * @author sdc
 *
 */
@Component
public class ESRepositoryV2 {

	private static final Logger log = LoggerFactory.getLogger(ESRepositoryV2.class);

	@Autowired
	private TransportClient client;
     /**
      *  批量添加数据
      * @Title: addItemDataToEs  
      * @Description: 这里用一句话描述这个方法的作用
      * @param @param items
      * @return void
      * @throws  
      * @author lsh10752
      * @date 2018年8月7日
      */
    public String addItemDataToEs(List<Item> items) {       
        BulkRequestBuilder prepareBulk = client.prepareBulk();
        for (Item item:items){
        	String jsonString = JSONObject.toJSONString(item);
        	 JSONObject  jsonObject = JSONObject.parseObject(jsonString);
        	    //json对象转Map
        	    Map<String,Object> map = (Map<String,Object>)jsonObject;
        	prepareBulk.add(client.prepareIndex(String.valueOf(ProductModule.product),String.valueOf(ProductModule.items))
        			.setId(String.valueOf(item.getId())).setSource(map));
              }
        
        BulkResponse bulkResponse=prepareBulk.execute().actionGet();
        prepareBulk.request().requests().clear();
        if (bulkResponse.hasFailures()){
            System.out.print("Fail");
        }
        System.out.print(bulkResponse.status());
        log.info("addItemDataToEs 批量添加数据状态:{}", " 是否有失败： "+bulkResponse.hasFailures()+" 状态："+bulkResponse.status());     
        return String.valueOf(bulkResponse.status());
    }
	
    
    /**
     * 查询数据
     * @param index 索引<----->关系型数据库
     * @param type  类型<----->关系型数据表
     * @param id    数据ID<----->id
     * @return
     */
    public SearchResponse searchItemDataByParam(String index, String type,BoolQueryBuilder boolQuery,int pageNow,int pageSize) {    	
    	//来获取查询数据信息
    	/*SearchResponse response = client.prepareSearch("index1", "index2")
    	        .setTypes("type1", "type2")
    	        .setQuery(QueryBuilders.termQuery("multi", "test"))                 // Query
    	        .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
    	        .setFrom(0).setSize(60)
    	        .get();*/
    	
    /*	SearchResponse response = client.prepareSearch(index)
    	        .setTypes(type)
    	        .setQuery(QueryBuilders.matchQuery("id", id))
    	       // .setQuery(QueryBuilders.termQuery("multi", "test"))                 // Query
    	        //.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
    	        .setFrom(0).setSize(60)
    	        .get();*/
    	
    	SearchResponse response = client.prepareSearch(index)
    	        .setTypes(type)
    	        .setQuery(boolQuery)
    	       // .setQuery(QueryBuilders.termQuery("multi", "test"))                 // Query
    	        //.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
    	        .setFrom(pageNow-1).setSize(pageSize)
    	        .get();   	
    	return response;
    }
    
    
    
    
    
	/**
	 * 创建索引
	 *
	 * @param index
	 * @return
	 */
	public boolean buildIndex(String index) {
		if (!isIndexExist(index)) {
			log.info("Index is not exits!");
		}
		CreateIndexResponse buildIndexresponse = client.admin().indices().prepareCreate(index).execute().actionGet();
		log.info(" 创建索引的标志: " + buildIndexresponse.isAcknowledged());

		return buildIndexresponse.isAcknowledged();
	}
	
	 /**
     * 删除索引
     *
     * @param index
     * @return
     */
    public boolean deleteIndex(String index) {
        if (!isIndexExist(index)) {
            log.info(" 索引不存在 ！！！！！!");
        }
        DeleteIndexResponse diResponse = client.admin().indices().prepareDelete(index).execute().actionGet();
        if (diResponse.isAcknowledged()) {
        	log.info("删除索引**成功** index->>>>>>>" + index);
        } else {
        	log.info("删除索引**失败** index->>>>> " + index);
        }
        return diResponse.isAcknowledged();
    }
    
    
    /**
     * 根据商品code查询商品属性
     * @Title: searchItemsAttrDataByItemCodes  
     * @Description: TODO(这里用一句话描述这个方法的作用)  
     * @param @param index
     * @param @param type
     * @param @param itemCodes
     * @param @return
     * @return SearchResponse
     * @throws  
     * @author lsh10752
     * @date 2018年8月2日
     */
	public SearchResponse searchItemsAttrDataByItemCodes(String index, String type, List<String> itemCodes) {
		if(index == null || type == null || itemCodes == null||itemCodes.size()==0) {
    		log.info(" 无法查询数据，缺唯一值!!!!!!! ");
    		return null;
    	}
		SearchResponse response = client.prepareSearch(index)
    	        .setTypes(type)
    	        .setQuery(QueryBuilders.termsQuery("code.keyword", itemCodes))
    	        .get();   	       
		return response;
	}
    /**
     * 更新数据
     *
     * @param data  添加的数据类型 json格式的
     * @param index 索引<----->关系型数据库
     * @param type  类型<----->关系型数据表
     * @param id    数据ID<----->id
     * @return
     */
    public void updateDataById(JSONObject data, String index, String type, String id) {
    	if(index == null || type == null || id == null) {
    		log.info(" 无法更新数据，缺唯一值!!!!!!! ");
    		return;
    	}
    	
    	//更新步骤
        UpdateRequest up = new UpdateRequest();
        up.index(index).type(type).id(id).doc(data);

        //获取响应信息
        //.actionGet(timeoutMillis)，也可以用这个方法，当过了一定的时间还没得到返回值的时候，就自动返回。
        UpdateResponse response = client.update(up).actionGet();
        log.info("更新数据状态信息，status{}", response.status().getStatus());
    }
    
    /**
     * 添加数据
     *
     * @param data  添加的数据类型 json格式的
     * @param index 索引<----->关系型数据库
     * @param type  类型<----->关系型数据表
     * @param id    数据ID<----->id
     * @return
     */
    public String addTargetDataALL(JSONObject data, String index, String type, String id) {
    	//判断一下次id是否为空，为空的话就设置一个id
    	if(id == null) {
    		id = UUID.randomUUID().toString();
    	}
    	//正式添加数据进去
        IndexResponse response = client.prepareIndex(index, type, id).setSource(data).get();
        
        log.info("addTargetDataALL 添加数据的状态:{}", response.status().getStatus());
        
        return response.getId();
    }
    
    /**
     * 通过ID删除数据
     *
     * @param index 索引，类似数据库
     * @param type  类型，类似表
     * @param id    数据ID
     */
    public void delDataById(String index, String type, String id) {

    	if(index == null || type == null || id == null) {
    		log.info(" 无法删除数据，缺唯一值!!!!!!! ");
    		return;
    	}
    	//开始删除数据
        DeleteResponse response = client.prepareDelete(index, type, id).execute().actionGet();

        log.info("删除数据状态，status-->>>>{},", response.status().getStatus());
    }

	/**
	 * 判断索引是否存在
	 *
	 * @param index
	 * @return
	 */
	public boolean isIndexExist(String index) {
		IndicesExistsResponse iep = client.admin().indices().exists(new IndicesExistsRequest(index)).actionGet();
		if (iep.isExists()) {
			log.info("此索引 [" + index + "] 已经在ES集群里存在");
		} else {
			log.info(" 没有此索引 [" + index + "] ");
		}
		return iep.isExists();
	}

}

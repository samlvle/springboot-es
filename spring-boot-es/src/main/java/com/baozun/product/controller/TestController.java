package com.baozun.product.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHits;
import org.githup.es.constants.ESWebStatusEnum;
import org.githup.es.constants.ResponseVo;
import org.githup.es.controller.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baozun.product.customer.GetItemListbyConditionsV1Param;
import com.baozun.product.service.EsItemService;
import com.baozun.product.vo.ItemV1SolrVO;
import com.mysql.fabric.xmlrpc.base.Array;

import io.swagger.annotations.ApiParam;
@RestController
@RequestMapping("/test")
public class TestController extends BaseController{
@Value("${start}")
private Long start;
@Value("${size}")
private Integer size;	
@Resource	
private EsItemService esItemService;
	/**
	 * 构建索引
	 * @param index
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/queryItem")
	@ResponseBody
	public ResponseVo<?> queryItem() throws Exception {		
	return generateResponseVo(ESWebStatusEnum.SUCCESS, esItemService.queryItemsAndSaveToEs(start,size));
	}
	/**
	 * 同步数据到es
	 * @param index
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/queryItemToEs")
	@ResponseBody
	public ResponseVo<?> queryItemToEs()  {	
		Long maxId = esItemService.queryMaxId();		
		      new Thread(new Runnable() {
						public void run() {
							 while (true) {
								if (!start .equals(maxId) ) {
							start = esItemService.queryItemsAndSaveToEs(start, size);
							System.out.println(Thread.currentThread().getName() + " start=" + start+" maxId="+maxId);
						} else {							
							break ;
						}
					}
						}
					}).start();	
	return generateResponseVo(ESWebStatusEnum.SUCCESS,null );
	}
	
	/**
	 * 同步数据到es
	 * @param index
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/queryItemFromEs")
	@ResponseBody
	public ResponseVo<?> queryItemFromEs(@RequestBody @ApiParam(name = "GetItemListbyConditionsV1Param", value = "请求参数") GetItemListbyConditionsV1Param request)  {
		
		
		 List<Object> list=new ArrayList<Object>();
		 SearchResponse queryItemByCondition = esItemService.queryItemByCondition(request);
		 SearchHits hits = queryItemByCondition.getHits(); 
		 for (int i = 0; i < hits.getHits().length; i++) { 
			 
			 String sourceAsString = hits.getHits()[i].getSourceAsString();						 
			 list.add( JSON.parseObject(sourceAsString, ItemV1SolrVO.class));}
		           // System.out.println(hits.getHits()[i].getSourceAsString());} 
		return generateResponseVo(ESWebStatusEnum.SUCCESS,list);
	}		

}
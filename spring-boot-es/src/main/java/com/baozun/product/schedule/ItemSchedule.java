package com.baozun.product.schedule;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.baozun.product.service.EsItemService;
/**
 * 同步商品信息到ES中
 * 
 * @author lsh10752
 *
 */
@Component
@EnableAsync
public class ItemSchedule {
	
	private final static Logger logger = LoggerFactory.getLogger(ItemSchedule.class);
	@Resource	
	private EsItemService esItemService;	
	@Value("${start}")
	private Integer start;
	@Value("${size}")
	private Integer size;			
	@PostConstruct
	public void init()
	{		

	}

	 @Async
	 @Scheduled(cron="0 0/15 1,2 * * ?") //fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
	 public void queryItemsInfo() throws Exception {	    
		// esItemService.queryItemsAndSaveToEs(start,size);
	 }	    
}

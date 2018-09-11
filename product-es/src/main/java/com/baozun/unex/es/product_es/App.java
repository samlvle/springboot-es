package com.baozun.unex.es.product_es;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.baozun.product.es.EnableSearch;
//@ComponentScan(basePackages={"com.baozun.product.es.controller.user"}) // 扫描该包路径下的所有spring组件
//@EnableElasticsearchRepositories(basePackages = "com.baozun.product.es.repository")
@EnableSearch
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		  //容器启动初始化SpringBoot
        SpringApplication.run(App.class, args);
		
	}
}

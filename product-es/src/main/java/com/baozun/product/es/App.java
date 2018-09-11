package com.baozun.product.es;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
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

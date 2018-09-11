package com.baozun.product.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * springboot starter
 * 
 * 备注：平常测试的类
 * 
 * @author sdc
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "org.githup","com.baozun.product" })
@MapperScan("com.baozun.product.es.mapper")
public class SpringBootEsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEsApplication.class, args);
	}
}

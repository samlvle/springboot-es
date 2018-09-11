package com.baozun.product.es;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * @ClassName: EnableSearch  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author lsh10752  
 * @date 2018年7月16日  
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({SearchConfig.class})
public @interface EnableSearch {
}

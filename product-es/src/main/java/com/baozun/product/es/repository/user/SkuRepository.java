package com.baozun.product.es.repository.user;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.baozun.product.es.repository.user.entity.ItemDocument;
import com.baozun.product.es.repository.user.entity.User;
import java.util.List;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/11/27 下午10:10
 * @desc 用户仓库.
 */
public interface SkuRepository extends ElasticsearchRepository<ItemDocument, Long>{

    List<ItemDocument> findByName(String name);

}

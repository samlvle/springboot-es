package com.baozun.product.es.controller.user;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import com.baozun.product.es.repository.user.ItemRepository;
import com.baozun.product.es.repository.user.UserRepository;
import com.baozun.product.es.repository.user.entity.ItemDocument;
import com.baozun.product.es.repository.user.entity.User;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/11/27 下午10:13
 * @desc 用户搜索添加.
 */

@RestController
public class UserController {

    @Resource
    UserRepository userRepository;
    @Resource
    ItemRepository itemRepository;

    @RequestMapping(value="/saveUser",method={RequestMethod.POST})
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }


    @RequestMapping(value="/saveItem",method={RequestMethod.POST})
    public void saveUser(@RequestBody ItemDocument itemDocument) {
    	itemRepository.save(itemDocument);
    }
    @RequestMapping(value="/getItemByName",method={RequestMethod.POST})
    public List<ItemDocument> getItemByName(@RequestBody ItemDocument itemDocument) {
        return itemRepository.findByName(itemDocument.getName());
    }
    
    
    @DeleteMapping("/{id:\\d+}")
    public void removeUser(@PathVariable("id") Long id) {
        //userRepository.delete(id);
        userRepository.deleteById(id);
    }

    @PostMapping("/list")
    public void saveUsers(@RequestBody List<User> users) {
       // userRepository.save(users);
        userRepository.saveAll(users);
    }

    @RequestMapping(value="/getUserByUsername",method={RequestMethod.POST})
    public List<User> getUserByUsername(@RequestBody String userName) {
        return userRepository.findByUsername(userName);
    }

    @GetMapping("/ageTo/{ageTo}/name_start/{nameStart}/id/{id:\\d+}")
    public List<User> getUserByAgeAndUsernameAndId(@PathVariable Integer ageTo, @PathVariable String nameStart,
                                                 @PathVariable Long id) {
        return userRepository.findByAgeBeforeAndUsernameStartingWithAndIdGreaterThanOrderByAgeDesc(ageTo, nameStart, id);
    }
}

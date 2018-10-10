package org.moy.spring.test.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> hello world
 * Created on 2018/10/10
 *
 * @author 叶向阳
 * @since 1.0
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hi(){
        return "hello world!";
    }

}

package com.JBDL.LoadBalancerTry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String sayHello()
    {
        return ("Hi ,we are ready");
    }
}

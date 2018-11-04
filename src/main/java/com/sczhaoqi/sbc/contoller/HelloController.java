package com.sczhaoqi.sbc.contoller;

import com.sczhaoqi.sbc.beans.UserInfo;
import io.swagger.annotations.ApiParam;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping
    public String index(){
        return "Index";
    }

    @ApiParam(name = "welcome", value= "send a welcome to user")
    @GetMapping("welcome")
    public String welcome(){
        return "Welcome!";
    }

    @ApiParam(name = "hello", value= "send a hello to this server, get a response of user info")
    @GetMapping("hello")
    public String hello(){
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return "hello,"+userInfo.getName();
    }
}

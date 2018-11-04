package com.sczhaoqi.sbc.contoller;

import com.sczhaoqi.sbc.beans.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @ApiParam(name = "hello", value= "send a hello to this server, get a response of user info")
    @GetMapping("hello")
    public String hello(){
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return "hello,"+userInfo.getName();
    }
}

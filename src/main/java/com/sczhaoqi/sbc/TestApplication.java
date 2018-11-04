package com.sczhaoqi.sbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用于配置和启动引导
 */
@SpringBootApplication(scanBasePackages={"com.sczhaoqi.sbc"})
public class TestApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TestApplication.class, args);
    }
}

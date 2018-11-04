package com.sczhaoqi.sbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    /**
     * 注意：这里可以定义多个bean
     * 启动工程后仅仅需打开http://ip:端口号/swagger-ui.html 链接即可使用swagger
     */
    @Bean
    public Docket testApi()
    {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("com.sczhaoqi")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(or(regex("/*/.*")))//过滤的接口
                .build()
                .apiInfo(testApiInfo());
    }

    private ApiInfo testApiInfo()
    {
        return new ApiInfoBuilder()
                .title("SpringBoot Cas DEMO")//大标题
                .description("SpringBoot+Cas.")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("Q", "", "1151324240@qq.com"))//作者
                .build();
    }
}
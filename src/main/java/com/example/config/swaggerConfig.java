package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @ClassName swaggerConfig
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/3/5
 * @Version V1.0
 **/
@Configuration
@EnableSwagger2 //开启swagger2  http://localhost:8080/swagger-ui.html
public class swaggerConfig {

    //多个组
    @Bean
    public Docket docketA(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docketB(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docketC(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置swaggerde bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的环境
        Profiles profiles=Profiles.of("dev");
        //获取项目的环境
       boolean flag= environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("高翔")
                .enable(flag)  //是否开启
                .select()
                //配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                //过滤什么路径
               // .paths(PathSelectors.ant("/example/**"))
                .build();
    }
    //配置swagger信息apiinfo
    private ApiInfo apiInfo(){
        //作者信息
       Contact contact= new Contact("高翔", "", "");
        return new ApiInfo(
                "高翔的swagger api文档",
                "Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );

    }
}

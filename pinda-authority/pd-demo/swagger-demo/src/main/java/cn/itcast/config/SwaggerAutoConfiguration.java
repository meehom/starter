package cn.itcast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 自动配置类
 *
 * @author Administrator
 */
@Configuration
@EnableSwagger2
public class SwaggerAutoConfiguration {

    @Bean
    public Docket createRestApi1() {
        //ApiInfo apiInfo = new ApiInfoBuilder().title("我的接口文档").contact(new Contact("百度首页", "https://www.baidu.com", "747011882@qq.com")).version("1.0").description("接口文档描述").build();

        //docket对象用于封装接口文档相关信息
        Docket docket = new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).groupName("用户接口组").
                //apiInfo(apiInfo).
                        groupName("用户接口组").select().
                        apis(RequestHandlerSelectors.basePackage("cn.itcast.controller")).
                        build();
        return docket;
    }

    @Bean
    public Docket createRestApi2() {
        //ApiInfo apiInfo = new ApiInfoBuilder().title("我的接口文档").contact(new Contact("百度首页", "https://www.baidu.com", "747011882@qq.com")).version("1.0").description("接口文档描述").build();

        //docket对象用于封装接口文档相关信息
        Docket docket = new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).groupName("菜单接口组").
                //apiInfo(apiInfo).
                        groupName("菜单接口组").select().
                        apis(RequestHandlerSelectors.basePackage("cn.itcast.controller.menu")).
                        build();
        return docket;
    }

    //构建 api文档的详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("API接口文档")
                //创建人
                .contact(new Contact("黑马程序员", "http://www.itheima.com", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}

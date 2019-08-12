package com.atguigu.config;

import com.atguigu.component.LoginHandlerInterceptor;
import com.atguigu.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @author 黄明潘
 * @date 2019/8/11-15:14
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    //所有的WebMvcConfigurer组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            /**
             * urlPath 请求路径
             * @param registry
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/main").setViewName("main");
            }

            //拦截器配置Begin
            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index","/","/login","/static/**","/webjars/**","/asserts/**");
            }

            /**
             * 添加静态资源文件，外部可以直接访问地址
             * @param registry
             */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            }
            //拦截器配置End
        };
        return configurer;
    }
    //页面国际化配置
    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }

}

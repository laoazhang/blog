package com.laoazhang.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/9 15:10
 * @Description: 告诉浏览器，我允许哪些服务器访问，哪些请求方式访问，是否运行携带请求头
 * @Version 1.0
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 1. 添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();

        // 2.允许的域,不要写*，否则cookie就无法使用了
        config.addAllowedOriginPattern("*");
        config.addAllowedOriginPattern("http://127.0.0.1:8081");
        config.addAllowedOriginPattern("http://localhost:8081");
        config.addAllowedOriginPattern("http://127.0.0.1:80");
        config.addAllowedOriginPattern("http://localhost:80");
        config.addAllowedOriginPattern("http://127.0.0.1");
        config.addAllowedOriginPattern("http://localhost");

        // 3.是否允许发送Cookie信息
        config.setAllowCredentials(true);

        // 4.允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");

        // 5.允许的头信息
        config.addAllowedHeader("*");

        // 6.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new
                UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        // 7.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}

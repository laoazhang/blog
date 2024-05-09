package com.laoazhang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 14:04
 * @Description: 主启动类
 * @Version 1.0
 */
@MapperScan("com.laoazhang.**.mapper")
@SpringBootApplication
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
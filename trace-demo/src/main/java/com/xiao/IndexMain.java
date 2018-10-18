package com.xiao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jinwei.sun on 2017/2/24.
 *
 * @author sunjinwei
 * <p>
 * 入口文件
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiao"})
public class IndexMain {


    public static void main(String[] args) {
        SpringApplication.run(IndexMain.class, args);
    }


}

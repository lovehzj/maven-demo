package com.github.shoothzj.demo.skywalking.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hezhangjian
 */
@Slf4j
@SpringBootApplication
public class HttpMain {

    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication.run(HttpMain.class);
    }

}

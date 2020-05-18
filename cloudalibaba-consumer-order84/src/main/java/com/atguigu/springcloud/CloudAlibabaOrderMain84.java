package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-18 14:10
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudAlibabaOrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaOrderMain84.class, args);
    }
}

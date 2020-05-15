package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-15 10:08
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrderConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderConsumerMain83.class, args);
    }
}

package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <h3>cloud2020</h3>
 * <p>主启动类</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-08 11:19
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8006.class, args);
    }
}

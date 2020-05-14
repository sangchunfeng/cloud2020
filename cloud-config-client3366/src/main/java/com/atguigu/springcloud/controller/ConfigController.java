package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-13 13:55
 * @version: 1.0
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/config/client/info")
    public String info() {
        return info;
    }

}

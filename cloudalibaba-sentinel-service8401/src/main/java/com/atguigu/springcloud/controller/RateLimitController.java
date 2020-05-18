package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-18 13:05
 * @version: 1.0
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "byResourceHandler")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称访问", new Payment(2020L, "serial001"));
    }

    public CommonResult byResourceHandler(BlockException exception) {
        return new CommonResult(444, "服务不可用");
    }


    @GetMapping("/byurl")
    @SentinelResource(value = "byUrl",
                      blockHandlerClass = CustomerBlockHandler.class,
                      blockHandler = "handlerException2")
    public CommonResult byUrl() {
        return new CommonResult(200, "按URL访问", new Payment(2020L, "serial001"));
    }

}

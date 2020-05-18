package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-18 14:13
 * @version: 1.0
 */
@RestController
public class PaymentController {

    @Value("${service-url}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/customer/payment/get/{id}")
    @SentinelResource(value =  "fallback", fallback = "handlerFallback")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (id == null) {
            throw new NullPointerException("数据为空") ;
        }
        return restTemplate.getForObject(serviceUrl +  "/payment/get/" + id, CommonResult.class);

    }

    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable t) {
        return new CommonResult(4444, "handler fallback");

    }

    @GetMapping("/customer/feign/get/{id}")
    public CommonResult getPaymentFeign(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }

}

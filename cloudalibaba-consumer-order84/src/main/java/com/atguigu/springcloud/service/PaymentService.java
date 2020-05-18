package com.atguigu.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-18 15:15
 * @version: 1.0
 */
@FeignClient(value = "cloudalibaba-provider-payment", fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    CommonResult getPayment(@PathVariable("id") Long id);
}

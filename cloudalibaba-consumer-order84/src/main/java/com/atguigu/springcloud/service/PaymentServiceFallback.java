package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.CommonResult;
import org.springframework.stereotype.Component;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-18 15:17
 * @version: 1.0
 */
@Component
public class PaymentServiceFallback implements PaymentService {
    @Override
    public CommonResult getPayment(Long id) {
        return new CommonResult(444, "服务降级调用");
    }
}

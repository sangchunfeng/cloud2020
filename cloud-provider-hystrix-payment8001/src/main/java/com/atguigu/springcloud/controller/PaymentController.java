package com.atguigu.springcloud.controller;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-08 12:59
 * @version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果是：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功, serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败, serverPort: " + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Integer> getPaymentById(@PathVariable(value = "id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果是：" + payment);
        if (null != payment) {
            return new CommonResult(200, "查询成功, serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败, serverPort: " + serverPort, null);
        }
    }

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") int id) {
        return "线程池: " + Thread.currentThread().getName() + ",ok_id: " + id;

    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") int id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + ",timeout_id: " + id;
    }

    public String paymentTimeoutHandler(int id) {
        return "系统繁忙，请稍后再试" + id;
    }

    @GetMapping("/payment/hystrix/circut/{id}")
    @HystrixCommand(fallbackMethod = "paymentCircutFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircut(@PathVariable("id") int id) {
        if (id < 0) {
            throw  new RuntimeException("id不能为负数");
        } else {
            return "订单流水号: " + IdUtil.simpleUUID();
        }
    }

    public String paymentCircutFallback(int id) {
        return "id不能为负数: " + id;
    }
}

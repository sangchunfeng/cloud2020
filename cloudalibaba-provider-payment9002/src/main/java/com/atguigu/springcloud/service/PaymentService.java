package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-08 12:54
 * @version: 1.0
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}

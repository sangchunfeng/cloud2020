package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-19 10:48
 * @version: 1.0
 */
@Component
public interface OrderService {

    //新建订单
    void create(Order order);
}

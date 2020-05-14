package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-11 11:46
 * @version: 1.0
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> instances);

}

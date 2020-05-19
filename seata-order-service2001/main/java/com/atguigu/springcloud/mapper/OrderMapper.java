package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-19 10:47
 * @version: 1.0
 */
@Mapper
public interface OrderMapper {

    //新建订单
    void create(Order order);
    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId,
                @Param("status") Integer status);

}

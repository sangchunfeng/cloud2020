package com.atguigu.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-19 13:10
 * @version: 1.0
 */
@Mapper
public interface StorageMapper {
    //扣减库存信息
    void decrease(@Param("productId") Long productId,
                  @Param("count") Integer count);
}

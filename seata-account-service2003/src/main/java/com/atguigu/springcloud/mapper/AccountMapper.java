package com.atguigu.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-19 13:24
 * @version: 1.0
 */
@Mapper
public interface AccountMapper {
    void decrease(@Param("userId") Long userId,
                  @Param("money") BigDecimal money);
}

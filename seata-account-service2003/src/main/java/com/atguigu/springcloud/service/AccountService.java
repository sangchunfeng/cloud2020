package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-19 13:27
 * @version: 1.0
 */
public interface AccountService {

    void decrease(@RequestParam("userId") Long userId,
                  @RequestParam("money") BigDecimal money);
}

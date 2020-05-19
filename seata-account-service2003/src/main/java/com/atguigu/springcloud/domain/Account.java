package com.atguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-19 13:22
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;


    /**
      * 用户id
      */
    private Long userId;


    /**
      * 总额度
      */
    private BigDecimal total;


    /**
      * 已用额度
      */
    private BigDecimal used;
    /**
      * 剩余额度
      */
    private BigDecimal residue;
}

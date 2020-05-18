package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.pojo.CommonResult;

/**
 * <h3>cloud2020</h3>
 * <p>${description}</p>
 *
 * @author: sangchunfeng
 * @date: 2020-05-18 13:48
 * @version: 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(4444, "global exception handler----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "global exception handler----2");
    }

}

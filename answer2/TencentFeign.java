package com.wsn.powerstrip.communication.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wangzilinn@gmail.com
 * @Date: 3/16/2021 4:31 PM
 */
@FeignClient(url = "https://gw.tvs.qq.com/echo")
public interface TencentFeign {
    @GetMapping
    TencentResponse getTencentData(@RequestParam(value = "msg") String message);
}

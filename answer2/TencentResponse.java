package com.wsn.powerstrip.communication.feign;

import lombok.Data;

/**
 * @Author: wangzilinn@gmail.com
 * @Date: 3/16/2021 4:32 PM
 */
@Data
public class TencentResponse {
    private String echoMsg;
    private Result result;

    @Data
    public static class Result{
        private Integer code;
        private String message;
        private String sessionId;
        private String randomData;
    }
}

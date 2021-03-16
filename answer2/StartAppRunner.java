package com.wsn.powerstrip;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.powerstrip.communication.feign.TencentFeign;
import com.wsn.powerstrip.communication.feign.TencentResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * UTF-8
 * Created by czy  Time : 2020/10/21 10:49
 *
 * @version 1.0
 */
@Component
public class StartAppRunner implements CommandLineRunner {
    final private TencentFeign tencentFeign;
    final private ObjectMapper objectMapper = new ObjectMapper();

    public StartAppRunner(TencentFeign tencentFeign) {
        this.tencentFeign = tencentFeign;
    }

    @Override
    public void run(String... args) throws Exception {
        TencentResponse response = tencentFeign.getTencentData("abc123xyz");
        System.out.println(response);
        String s = objectMapper.writeValueAsString(response);
        // 替换数字:
        String output = s.replaceAll("[0-9]", "-");
        //输出替换的数字:
        System.out.println(output);
    }
}

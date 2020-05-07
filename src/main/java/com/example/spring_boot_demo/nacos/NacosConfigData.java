package com.example.spring_boot_demo.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName : NacosConfig
 * @Description : 通用配置类
 * @Author : sky
 * @Date: 2020-05-07 15:14
 *
 * 启动 Nacos 服务 新建如下配合信息
 * nacos.test.appName=skyApp
 * nocos.test.appNum=3
 * nocos.test.isStart=true
 */
@Component
public class NacosConfigData {
    private String appName;
    private boolean isStart;
    private int appNum;
    @NacosValue(value = "${nacos.test.appName}", autoRefreshed = true)
    public void setAppName(String appName) {
        this.appName = appName;
    }
    @NacosValue(value = "${nocos.test.isStart}", autoRefreshed = true)
    public void setStart(boolean start) {
        isStart = start;
    }
    @NacosValue(value = "${nocos.test.appNum}", autoRefreshed = true)
    public void setAppNum(int appNum) {
        this.appNum = appNum;
    }

    public  String getAppName() {
        return appName;
    }

    public  boolean isIsStart() {
        return isStart;
    }

    public  int getAppNum() {
        return appNum;
    }
}

package com.atguigu.gmall.pms;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * dubbo原理：
 *  1）rpc 两个不同的服务（进程，机器）。建立连接，传输数据
 *  2）dubbo的那张流程图，服务器提供，消费，注册中心，监控中心
 *
 */
@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "com.atguigu.gmall.pms.mapper")
public class GmallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallPmsApplication.class, args);
    }

}

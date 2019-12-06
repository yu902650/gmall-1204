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
 *  联调：
 *      前端Vue,后台开发Server；（接口文档swagger）
 *      接口文档：研讨每一个功能的设计（数据库，接口的设计，业务逻辑的设计）
 *          1）.后台程序员知道前端需要什么数据，能传来数据
 *          2）.原型：（原型设计师 UE）
 *                  1— UI:设计页面 安卓 ios web
 *                  2— 后端：按照原型来进行功能开发
 *              需求分析（设计）---编码---测试---上线
 *
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

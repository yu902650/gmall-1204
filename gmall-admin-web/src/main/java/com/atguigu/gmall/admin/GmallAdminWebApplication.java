package com.atguigu.gmall.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Vo : 视图对象
 *      a.前端需要的数据封装为Vo数据，（user 20个字段， userVo 5个字段）
 *      b.User{ };
 *          用户注册：
 *              用户提交一个手机号： user=100个字段 ；内存中创建大对象
 *              userService.register(user)
 *       request --> 提交的vo
 *
 * Dao : 数据库访问对象
 * Pojo ：plain old java object 封装数据
 * Do : data object 数据对象：POJO 数据库表的实体类。
 * To : transfer object 传输对象
 *      a. 服务之间互调，为了数据传输封装对象
 *      b. aService(){
 *          user,movie
 *      }
 *      bService(用户名和电影名 UserMovieTo)
 * Dto :
 *
 * @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) 【排除管理数据源的自动配置】
 * 1.不进行数据源的自动配置
 *
 * 如果导入的依赖，引入一个自动配置场景；
 * 1）、这个场景自动配置默认生效，我们就必须配置他
 * 2）、不想配置；
 *      1）引入的时候排除这个场景依赖
 *      2）排除掉这个场景的自动配置类
 *
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GmallAdminWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallAdminWebApplication.class, args);
    }

}

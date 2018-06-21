package com.miracle.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.miracle.demo.dao")
@EnableAutoConfiguration//自动载入应用程序所需的所有Bean，当使用Exclude这个属性时，是禁止自动配置某个类
public class DemoApplication {
	public static void main(String[] args) {
//		全异步模式
//		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		SpringApplication.run(DemoApplication.class, args);
	}
}

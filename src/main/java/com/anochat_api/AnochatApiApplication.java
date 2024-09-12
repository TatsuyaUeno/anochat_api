package com.anochat_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Bootの起動をするクラス
 * 自動で生成される
 * @author
 *
 */
@SpringBootApplication
@MapperScan("com.anochat_api.mapper")
public class AnochatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnochatApiApplication.class, args);
	}

}

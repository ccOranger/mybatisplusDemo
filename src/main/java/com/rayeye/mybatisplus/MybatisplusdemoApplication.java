package com.rayeye.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.rayeye.mybatisplus.mapper")
public class MybatisplusdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisplusdemoApplication.class, args);
	}

}

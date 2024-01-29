package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.component.Bean3;
import com.example.demo.component.Game;
import com.example.demo.component.ImageUtil;
import com.example.demo.component.Movie;
import com.example.demo.component.Music;
import com.example.demo.config.BeanConfig;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		// JdbcTemplate jt = (JdbcTemplate) context.getBean("jdbcTemplate");
		// List<Map<String, Object>> list = jt.queryForList("select * from emp03");

		Movie bean3 = (Movie) context.getBean("movie");
		System.out.println(bean3.play());

		ImageUtil iu = (ImageUtil) context.getBean("imageUtil");
		try {
			iu.save("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

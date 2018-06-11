package com.luc.luc_bs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.luc.luc_bs.Dao")
/*public class LucBsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LucBsApplication.class, args);
	}

	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(LucBsApplication.class);
	}
}*/
public class LucBsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucBsApplication.class, args);
	}

}

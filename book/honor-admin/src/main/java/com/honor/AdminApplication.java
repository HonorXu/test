package com.honor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages= {"com.honor.dal.mapper"})
public class AdminApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{
	
	public static void main(String[] args) {
		System.out.println("启动springboot...");
		SpringApplication.run(AdminApplication.class, args);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		System.out.println("设置端口号8081...");
		container.setPort(8081);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(AdminApplication.class);
	}
}

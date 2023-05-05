package oss.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
public class  ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}
//	@Bean 경로적는걸 스프링부트 자동으로 해주니까 해줄 필요가없다.
//	ViewResolver  internalResourceViewResolver(){
//		return  new InternalResourceViewResolver("/WEB-INF/views",".jsp");
//	}
}

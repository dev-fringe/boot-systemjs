package dev.fringe.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
@ActiveProfiles("one")
public class FringeServiceApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(FringeServiceApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
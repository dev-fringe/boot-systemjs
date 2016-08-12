package dev.fringe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class FringeApplication extends ApiDocAndAsyncMessageConfig {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(FringeApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
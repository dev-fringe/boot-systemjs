package dev.fringe;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

public class FringeApplication extends AtmosphereSpringSupport {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(FringeApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
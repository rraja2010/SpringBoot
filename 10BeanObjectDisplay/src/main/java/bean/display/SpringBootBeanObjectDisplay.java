package bean.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootBeanObjectDisplay implements ApplicationRunner {
	
	@Autowired
    private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeanObjectDisplay.class, args);
		System.out.println("Server has started successfully!!!!!!!!!!!!!");
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		String[] beans = context.getBeanDefinitionNames();
		for (String beanName: beans) {
			System.out.println(beanName);
		}
	}
	
	// Implements the interface CommandLineRunner
	/*public void run(String... arg0) throws Exception {
		String[] beans = context.getBeanDefinitionNames();
		for (String beanName: beans) {
			System.out.println(beanName);
		}
	}*/
}

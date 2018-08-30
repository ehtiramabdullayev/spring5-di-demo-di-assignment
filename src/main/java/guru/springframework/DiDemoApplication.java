package guru.springframework;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.GetterInjectedController;
import guru.springframework.controllers.MyController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.services.GreetingService;
import guru.springframework.services.GreetingServiceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		GreetingServiceFactory factory = (GreetingServiceFactory) ctx.getBean("greetingServiceFactory");

		System.out.println(factory.createGreetingService("es").sayGreeting());
		System.out.println(factory.createGreetingService("en").sayGreeting());
		System.out.println(factory.createGreetingService("de").sayGreeting());

//		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
//		System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
//		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	}
}

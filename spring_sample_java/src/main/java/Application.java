import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.app.service.CustomerService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerService  service=context.getBean("customerService",CustomerService.class);
				
		System.out.println(service);
		CustomerService  service1=context.getBean("customerService",CustomerService.class);
		System.out.println(service1);
		System.out.println(service.findAll().get(0).getFirstName());
	}

}

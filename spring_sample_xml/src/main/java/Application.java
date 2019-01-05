import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.app.service.CustomerService;
import com.capgemini.app.service.CustomerServiceImpl;

public class Application {

	public static void main(String[] args) {
		//CustomerService  service = new CustomerServiceImpl();
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService  service=context.getBean("customerService",CustomerService.class);
		System.out.println(service);
		CustomerService  service1=context.getBean("customerService",CustomerService.class);
		System.out.println(service1);
		System.out.println(service.findAll().get(0).getFirstName());
	}

}

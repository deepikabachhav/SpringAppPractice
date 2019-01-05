import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.capgemini.app.repository.CustomerRepository;
import com.capgemini.app.repository.HibbernateCustomerRepositoryImpl;
import com.capgemini.app.service.CustomerService;
import com.capgemini.app.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.capgemini.app"})
public class AppConfig {
	
	/*
	 * @Bean(name="customerService") public CustomerService getCustomerService() {
	 * //CustomerServiceImpl service= new
	 * //CustomerServiceImpl(getCustomerRepository()); //constructor injection
	 * CustomerServiceImpl service= new CustomerServiceImpl(); //no-arg constructor
	 * //service.setCustomerRepository(getCustomerRepository()); //setter injection
	 * return service; }
	 * 
	 * @Bean(name="customerRepository") public CustomerRepository
	 * getCustomerRepository() { return new HibbernateCustomerRepositoryImpl(); }
	 * 
	 */
		
}

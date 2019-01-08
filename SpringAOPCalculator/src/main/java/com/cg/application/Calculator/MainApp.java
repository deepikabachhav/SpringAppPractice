package com.cg.application.Calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.application.service.Calculator;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("context.xml");
		Calculator calculator=context.getBean(Calculator.class);
		calculator.add(100,0);		
	}

}

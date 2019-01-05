package com.capgemini.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.spring.renderer.MessageRenderer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MessageRenderer renderer = context.getBean(MessageRenderer.class, "renderer");
		renderer.render();
	}
}

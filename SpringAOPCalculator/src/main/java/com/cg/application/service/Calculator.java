package com.cg.application.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

	public Integer add(int numberOne, int numberTwo) {
		System.out.println(numberOne+ numberTwo);
		return numberOne+numberTwo;
	}
}

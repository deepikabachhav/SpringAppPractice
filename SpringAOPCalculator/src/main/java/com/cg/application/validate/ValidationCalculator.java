package com.cg.application.validate;

import java.util.logging.Logger;

import org.aopalliance.intercept.Joinpoint;
//import org.apache.log4j.BasicConfigurator;
/*import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;*/
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationCalculator {
	private Logger logger = Logger.getLogger(ValidationCalculator.class.getName());

	@Before("execution(* com.cg.application.service.Calculator.add(..))")
	public void log1() {
		logger.info("Before- logging the method");
	}

	@After("execution(* com.cg.application.service.Calculator.add(..))")
	public void log2() {
		logger.info("After- logging the method");
	}

	@Around("execution(* com.cg.application.service.Calculator.add(..))")
	public void log3(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Around Before- logging the method");
		logger.info("Function name is" + pjp.getSignature());
		logger.info("Parameters are :");
		Object[] params = pjp.getArgs();
		for (int i = 0; i < params.length; i++) {
			logger.info("Parameter Value at index" + i + " is" + params[i]);
		}
		pjp.proceed();
		logger.info("Around After- logging the method");
	}

	@AfterReturning(pointcut = "execution(* com.cg.application.service.Calculator.add(..))", returning = "retVal")
	public void log4(Integer retVal) {
		logger.info("" + retVal);
	}

	@AfterThrowing(pointcut = "execution(* com.cg.application.service.Calculator.add(..))", throwing = "ex")
	public void log5(Joinpoint jp, Throwable ex) {
		logger.info(" AfterThrowing -Exception" + ex);
		System.out.println("error" + ex);
	}

}

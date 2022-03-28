package com.training.pms.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.training.pms.services.PatientServiceImpl;

@Component
@Aspect
public class LoggingAspect 
{
	private static Logger log = Logger.getLogger(LoggingAspect.class.getName());
	
	//"execution(* *(..)) && (within(com.training.controllers..*()) || within(com.training..services.*(..)) )"
	
	@Before(value = "execution(* com.training.pms.services..*(..)) || execution(* com.training.pms.controllers..*(..))")
	public void beforeCallLogging(JoinPoint jp)
	{
		log.info("Method " + jp.getSignature() + " was called");
	}
	
	@After(value = "execution(* com.training.pms.services..*(..)) || execution(* com.training.pms.controllers..*(..))")
	public void afterCallLogging(JoinPoint jp)
	{
		log.info("Method " + jp.getSignature() + " has completed");
		log.info("--------------------------------------------------------------------------------------------------------");
	}
	
	@AfterThrowing(pointcut = "execution(* com.training.pms.services..*(..)) || execution(* com.training.pms.controllers..*(..))", throwing = "ex")
	public void afterCatchLogging(Exception ex)
	{
		log.debug("Error caught | Error: " + ex.getMessage());	
	}
}

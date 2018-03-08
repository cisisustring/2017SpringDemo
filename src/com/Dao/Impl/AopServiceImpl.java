package com.Dao.Impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.Dao.IAopService;

@Aspect
@Component
public class AopServiceImpl implements IAopService {
	@Pointcut("execution(* com.Service.IAdminService.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	@Override
	public void beforeMethod(JoinPoint joinpoint) {
		// TODO Auto-generated method stub
		System.out.println(joinpoint.getSignature().getName() + "<---启动前的日志");
	}

	@After("pointCut()")
	@Override
	public void afterMethod(JoinPoint joinpoint) {
		// TODO Auto-generated method stub
		System.out.println(joinpoint.getSignature().getName() + "<---启动后的日志");

	}

}

package com.Dao;

import org.aspectj.lang.JoinPoint;

public interface IAopService {
public void beforeMethod(JoinPoint joinpoint);
public void afterMethod(JoinPoint joinpoint);
}

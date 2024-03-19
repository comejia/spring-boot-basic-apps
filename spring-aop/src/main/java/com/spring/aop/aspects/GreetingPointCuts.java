package com.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingPointCuts {

    @Pointcut("execution(public * com.spring.aop.services.GreetingService.*(..))")
    public void greetingPointCut() { }

    @Pointcut("execution(public * com.spring.aop.services.GreetingService.*(..))")
    public void fooPointCut() { }
}

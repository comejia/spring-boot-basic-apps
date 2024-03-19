package com.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Pointcut("execution(public * com.spring.aop.services.GreetingService.*(..))")
//    private void greetingPointCut() { }

    @Before("GreetingPointCuts.greetingPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes: " + method + " con los args " + args);
    }

    @After("GreetingPointCuts.greetingPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues: " + method + " con los args " + args);
    }

    @AfterReturning("GreetingPointCuts.greetingPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de retornar: " + method + " con los args " + args);
    }

    @AfterThrowing("GreetingPointCuts.greetingPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de lanzar la excepcion: " + method + " con los args " + args);
    }

    @Around("execution(public * com.spring.aop.services.GreetingService.*(..))")
    public Object loggerAAround(ProceedingJoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        try {
            logger.info("El metodo: " + method + "() con los parametros " + args);
            Object result = joinPoint.proceed();
            logger.info("El metodo: " + method + "() retorna el resultado " + result);
            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del metodo " + method + "()");
            throw new RuntimeException(e);
        }

        //return null;
    }
}


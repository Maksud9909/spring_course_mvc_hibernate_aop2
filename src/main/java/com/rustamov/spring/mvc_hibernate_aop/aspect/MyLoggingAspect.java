package com.rustamov.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyLoggingAspect {
    @Around("execution(* com.rustamov.spring.mvc_hibernate_aop.DAO.*.*(..))") // этот метод будет работать с любым методом в dao
    public Object aroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Begin of " + methodName);

        Object targetMethodResult =
                proceedingJoinPoint.proceed(); //  так как это around, мы должны сами написать, когда мы должны позвать метод

        System.out.println("End of " + methodName);

        return targetMethodResult;

    }
}

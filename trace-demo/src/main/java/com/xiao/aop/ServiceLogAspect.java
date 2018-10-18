package com.xiao.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by sunjinwei on 2018/2/2.
 *
 * @author sunjinwei
 * <p>
 * Service请求日志切面
 */
@Slf4j
@Aspect
@Component
@Order(2)
public class ServiceLogAspect {


    /**
     * 定义切面点 类方法
     */
    @Pointcut("execution(public * com.xiao.service..*.*(..))")
    public void serviceLog() {
    }


    /**
     * 定义前置通知
     */
    @Before("serviceLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        log.trace("###[serviceLog] classMethod:{}, args:{}",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "serviceLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.trace("###[serviceLog] response: " + ret);
    }
}

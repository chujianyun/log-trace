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
 *         <p>
 *         Dao请求日志切面
 */
@Slf4j
@Aspect
@Component
@Order(3)
public class DaoLogAspect {


//    /**
//     * 定义切面点 类方法
//     */
//    @Pointcut("execution(public * com.xiao.dao..*.*(..))")
//    public void daoLog() {
//    }
//
//
//    /**
//     * 定义前置通知
//     */
//    @Before("daoLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        log.trace("###[daoLog] classMethod:{}, args:{}",
//                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
//                Arrays.toString(joinPoint.getArgs()));
//
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "daoLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        log.trace("###[daoLog] response: " + ret);
//    }
}

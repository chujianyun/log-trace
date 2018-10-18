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
 *         Web请求日志切面
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class WebLogAspect {


//    /**
//     * 定义切面点 类方法
//     */
//    @Pointcut("execution(public * com.xiao.web..*.*(..))")
//    public void webLog() {
//    }
//
//
//    /**
//     * 定义前置通知
//     */
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        // 接收到请求，记录请求内容
//        log.trace("###[webLog] classMethod:{}, args:{}",
//                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
//                Arrays.toString(joinPoint.getArgs()));
//
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        log.trace("###[webLog] response: " + ret);
//    }
}

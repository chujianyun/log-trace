package com.xiao.interceptor;

import com.xiao.utils.IdGen;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sunjinwei on 2018/1/31.
 *
 * @author sunjinwei
 * <p>
 * 拦截器
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String uri = request.getRequestURI();
        String ip = request.getRemoteAddr();
        log.info("### LoginInterceptor,url:{},ip:{}", uri, ip);

        IdGen idGen = IdGen.get();
        MDC.put("traceId", idGen.nextId()+"");

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        MDC.clear();
    }

}

package com.xiao.web;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunjinwei on 2018/1/4.
 *
 * @author sunjinwei
 * 使用 spring boot 测试访问
 */
@Slf4j
@Controller
public class HelloWorldController {

    /**
     * 返回到 jsp 页面
     *
     * @return
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> welcome() {
        Map<String, Object> map = new HashMap<>();
        map.put("traceId", MDC.get("traceId"));
        log.info("### welcome:{}", "123");

        return map;
    }


    /**
     * 返回日志级别
     *
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("traceId", MDC.get("traceId"));

        log.debug("### test debug:{}", "debug");
        log.info("### test info:{}", "info");
        log.warn("### test warn:{}", "warn");

        return map;
    }

    /**
     * 设置日志级别
     *
     * @return
     */
    @RequestMapping(value = "/setLogLevel", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> setLogLevel(@RequestParam(defaultValue = "info") String level) {
        Map<String, Object> map = new HashMap<>();
        map.put("traceId", MDC.get("traceId"));

        //操作日志级别
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Level level1 = loggerContext.getLogger("com.xiao").getLevel();
        map.put("level1", level1);

        //设置日志级别
        loggerContext.getLogger("com.xiao").setLevel(Level.valueOf(level));
        Level level2 = loggerContext.getLogger("com.xiao").getLevel();
        map.put("leve2", level2);

        log.debug("### setLogLevel debug:{}", "debug");
        log.info("### setLogLevel info:{}", "info");
        log.warn("### setLogLevel warn:{}", "warn");

        return map;
    }

}

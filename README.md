# log-trace
使用logback 记录接口调用traceid 微服务全链路跟踪


- 1、添加拦截器，或者切面

```
参考切面  com.xiao.aop.ServiceLogAspect

参考拦截器 com.xiao.interceptor.LoginInterceptor
```

- 2、配置 logback 日志添加 traceId 参数

```
<appender name="console" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
        <pattern>%d{yy-MM-dd.HH:mm:ss.SSS} [%-16t] %-5p %-22c{0}  %X{ServiceId} [%X{traceId}] - %m%n</pattern>
    </encoder>
</appender>
```

- 3、程序中获取 traceId 参数

```
@RequestMapping(value = "/welcome", method = RequestMethod.GET)
@ResponseBody
public Map<String, Object> welcome() {
    Map<String, Object> map = new HashMap<>();
    map.put("traceId", MDC.get("traceId"));
    log.info("### welcome:{}", "123");

    return map;
}
```
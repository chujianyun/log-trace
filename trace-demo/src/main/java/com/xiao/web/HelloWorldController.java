package com.xiao.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String welcome() {
        log.info("### welcome:{}", "123");
        return "success";
    }


}

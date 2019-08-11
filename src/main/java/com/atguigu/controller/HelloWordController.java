package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 黄明潘
 * @date 2019/8/11-14:22
 */
@Controller
public class HelloWordController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWord() {
        return "hello word";
    }
}

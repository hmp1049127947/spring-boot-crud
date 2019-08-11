package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 黄明潘
 * @date 2019/8/11-14:22
 */
@Controller
public class LoginController {


    @PostMapping(value = "/login")
    public String login(@RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password,
                        Model model, HttpSession session){
        if (!StringUtils.isEmpty(username) && password.equals("123456")) {
            //登录成功
            session.setAttribute("user",username);
            return "redirect:/main";
        } else {
            //登录失败
            model.addAttribute("msg", "账户或密码错误");
            return "login";
        }
    }
}

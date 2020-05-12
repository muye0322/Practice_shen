package com.shen.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author  shentong
 * @date 2020/5/12
 */
@Controller
public class UserController {

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","傍晚");
        return "index";
    }

    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    public String login(String username,String pwd,Model model){
        //shiro认证
        //1 获取subject
        Subject subject = SecurityUtils.getSubject();
        //2 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,pwd);
        //3 执行登录操作
        try{
            subject.login(token);
            //登录成功
            return "redirect:index";
        }catch (UnknownAccountException e){
            //登录失败 用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            //登录失败,密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }

    /**
     * 跳转到更新页面
     * @return
     */
    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }

    /**
     * 跳转到未授权页面
     * @return
     */
    @RequestMapping("/unAuth")
    public String unAuth(){
        return "unAuth";
    }
}

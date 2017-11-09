package com.qhx.finish.myshop.controller;

import com.qhx.finish.myshop.model.User;
import com.qhx.finish.myshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by QIUHX on 2017/11/8.
 * user controller
 */
@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ModelAttribute
    public User getUser(){
        return new User();
    }

    /**
     * 退登
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:index";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/userLogin")
    public String userLogin(){
        return "login";
    }

    /**
     * 登录页面
     * @param user
     * @param checkcode
     * @param session
     * @param map
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(@ModelAttribute("user") User user, String checkcode ,
                        HttpSession session , Map<String , Object> map){
        String checkCode = (String)session.getAttribute("checkCode");
        //校验验证码
        if(!checkcode.equalsIgnoreCase(checkCode)){
            map.put("errorCheckCode","errorCheckCode");
            return "index";
        }

        //查看用户名是否存在
        User isExistUser = userService.checkUsername(user.getUsername());
        if(null == isExistUser){
            map.put("noUser","noUser");
            return "index";
        }

        //判断账号是否激活
        if(isExistUser.getState() == 0){
            map.put("noActiveUser" , "noActiveUser");
            return "index";
        }

        //判断用户输入的用户名和密码是否正确
        User u = userService.checkLoginInfo(user);
        if(null == u){
            map.put("errorUnameOrPwd","errorUnameOrPwd");
            return "index";
        }

        session.setAttribute("user", u);
        return "index";
    }

    /**
     * 激活用户
     * @param code
     * @param map
     * @return
     */
    @RequestMapping(value = "activeUser/{code}")
    public String activeUser(@PathVariable("code") String code , Map<String,Object> map){
        User user = userService.activeUser(code);
        if(null == user){
            map.put("errorCode","errorCode");
            //返回到注册msg页面
            return "msg";
        }
        //表示用户激活成功
        user.setCode("");
        //设置激活标识
        user.setState(1);
        userService.updateUserInfo(user);
        map.put("successActive","successActive");
        return "msg";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping(value = "/userRegister")
    public String userRegister(){
        return "register";
    }

    /**
     * 注册用户
     * @param user
     * @param result
     * @param session
     * @param checkCode
     * @param map
     * @return
     */
    @RequestMapping(value = "register" , method = RequestMethod.POST)
    public String register(@ModelAttribute("user") @Valid User user , BindingResult result ,
                           HttpSession session , String checkCode , Map<String , Object> map){
        //注册页面发生不知名错误,不使用BindingResult类的话就会直接报出异常,程序无法运行
        if(result.hasErrors()){
            List<ObjectError> errorInfo = result.getAllErrors();
            errorInfo.forEach(error->{
                logger.error("--->register meet error : {}" , error.getObjectName());
            });
            return "register";
        }
        //检验用户输入的校验码是否正确
        String checkcode = (String)session.getAttribute("checkcode");
        if(!checkcode.equalsIgnoreCase(checkCode)){
            map.put("errorCheckCode","errorCheckCode");
            return "register";
        }

        //检验用户名是否被注册
        User u = userService.checkUsername(user.getUsername());
        if(null != u){
            map.put("errorExistUser","errorExistUser");
            return "register";
        }

        //注册成功，往后台数据库保存用户，返回到首页
        userService.register(user);
        map.put("successRegister" , "successRegister");

        return "index";
    }


}

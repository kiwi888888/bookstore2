package com.yabai.servlet;

import com.yabai.entity.User;
import com.yabai.service.api.UserService;
import com.yabai.service.serviceImpl.UserServiceImpl;
import com.yabai.util.ViewBaseServlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends ViewBaseServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.获取用户填入的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        //2.用获取到的用户数据传给service

        User user = userService.login(username,password);


        //3.进行返回值的判空操作
        if (user==null){
            //登录失败，提示信息
            System.out.println("...");

        }else {
            //登录成功，跳转页面
            response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
        }



    }
}

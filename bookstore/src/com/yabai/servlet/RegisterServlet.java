package com.yabai.servlet;


import com.yabai.entity.User;
import com.yabai.service.api.UserService;
import com.yabai.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2023/05/22/21:15
 * @Description:
 */

public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User(null,username,password,email);

        //2.调用service方法
        boolean registerResult = userService.register(user);

        //3.判断返回值
        if (registerResult){
            response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.html");
        }else {
            response.sendRedirect("");
        }

    }
}

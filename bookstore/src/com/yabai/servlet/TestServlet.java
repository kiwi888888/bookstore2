package com.yabai.servlet; /**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2023/05/23/10:44
 * @Description:
 */

import com.yabai.util.ViewBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.text.View;
import java.io.IOException;

public class TestServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","atguigu");

        processTemplate("test",request,response);
    }
}

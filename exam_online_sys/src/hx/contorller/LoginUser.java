package hx.contorller;

import hx.userdao.UserFactory;
import hx.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user/login")
public class LoginUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //拿到用户的请求参数
        String userName,password,sex,email;
        userName = request.getParameter("username");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        System.out.println("用户成功提交了注册信息");
        try {
            Users user = new Users(null,userName,password,sex,email);
            user.setManager(false);//设置用户为管理员,用户提交的信息被加入到管理员表
            if (UserFactory.getUserDaoInstance().AddUser(user)) {
                if(user.isManager()){
                    out.println("<font style='color:green;font-size:30px'>恭喜您,注册成功!您成为了管理员</font>");
                }else{
                    out.println("<font style='color:green;font-size:30px'>恭喜您,注册成功!</font>");
                }
            } else {
                out.println("<font style='color:green;font-size:30px'>邮箱已存在,注册失败!</font>");
            }
        } catch (Exception e) {
            System.out.println("出现异常情况!");
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

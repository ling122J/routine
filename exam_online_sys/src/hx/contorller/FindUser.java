package hx.contorller;

import hx.userdao.UserFactory;
import hx.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user/find")
public class FindUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        try {
            List<Users> list =  UserFactory.getUserDaoInstance().findByUserEmail(email);
            request.setAttribute("userlist",list);
            request.getRequestDispatcher("/usershow.jsp").forward(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

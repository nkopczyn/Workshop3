package pl.coderslab.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.User;
import pl.coderslab.UserDao;

import java.io.IOException;

@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/add.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // obsługa formularza
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        // włożenie usera do database
        User user = new User();
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password);

        UserDao userDao = new UserDao();
        userDao.createUser(user);


        // przekierowanie na user/list
        response.sendRedirect(request.getContextPath() + "/user/list");



    }
}
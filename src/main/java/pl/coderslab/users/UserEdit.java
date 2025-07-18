package pl.coderslab.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.User;
import pl.coderslab.UserDao;

import java.io.IOException;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idParam = Integer.parseInt(request.getParameter("id")); // id przesyłane przez Get

        request.setAttribute("id", idParam);

        getServletContext().getRequestDispatcher("/users/edit.jsp")
                .forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // procesowanie odpowiedzi z formularza
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        int id = Integer.parseInt(request.getParameter("id"));
        // w edit.jsp jest ukryte pole które wczytuje id z Get jako parametr w formularzu type=hidden

        UserDao userDao = new UserDao();
        User userEdit = UserDao.readUser(id);

        userEdit.setUserName(username);
        userEdit.setEmail(email);
        userEdit.setPassword(password);

        UserDao.updateUser(userEdit);

        response.sendRedirect(request.getContextPath() + "/user/list");

    }
}
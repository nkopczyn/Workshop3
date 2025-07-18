 package pl.coderslab.users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.UserDao;

import java.io.IOException;

@WebServlet(name = "UserShow", value = "/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idParam = Integer.parseInt(request.getParameter("id"));

        UserDao userDao = new UserDao();

        // przekazanie usera do jsp
        request.setAttribute("readUser", userDao.readUser(idParam));


        getServletContext().getRequestDispatcher("/users/show.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
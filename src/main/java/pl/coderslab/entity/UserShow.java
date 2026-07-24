package pl.coderslab.entity;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try {
            User user = UserDao.getUserById(Integer.parseInt(id));
            request.setAttribute("user", user);
        } catch (SQLException e){
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/users/show.jsp")
                .forward(request, response);
    }

}

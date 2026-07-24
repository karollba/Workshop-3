package pl.coderslab.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//import pl.coderslab.DbUtil;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = UserDao.getAllUsers();
            request.setAttribute("users", users);
        } catch (SQLException e){
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);
    }
}

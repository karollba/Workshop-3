package pl.coderslab.entity;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");
            try {
                User user = UserDao.getUserById(Integer.parseInt(id));
                request.setAttribute("user", user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            getServletContext().getRequestDispatcher("/users/edit.jsp")
                    .forward(request, response);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("userName");
        String email = req.getParameter("userEmail");
        String password = req.getParameter("userPassword");

        try {
                UserDao.updateUser(id, username, email);

                if (password != null && !password.isEmpty()) {
                    UserDao.updatePassword(id, password);
                }
          } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/user/list");

    }

}

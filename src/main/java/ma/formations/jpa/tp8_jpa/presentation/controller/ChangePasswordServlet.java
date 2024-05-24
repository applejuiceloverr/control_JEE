package ma.formations.jpa.tp8_jpa.presentation.controller;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.tp8_jpa.service.IService;
import ma.formations.jpa.tp8_jpa.service.ServiceImpl;
import ma.formations.jpa.tp8_jpa.service.model.User;
import java.io.IOException;
@WebServlet("/changePassword.do")
public class ChangePasswordServlet extends HttpServlet {
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/changePassword.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String newPassword = request.getParameter("newPassword");

        service.changePassword(username, newPassword);

        response.sendRedirect("login.do");
    }
}
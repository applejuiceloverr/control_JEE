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
@WebServlet("/register.do")
public class CreateUserServlet extends HttpServlet {
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CreateUserServlet doGet called");
        request.getRequestDispatcher("/view/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // No need to encode here

        service.createUser(newUser);

        response.sendRedirect("login.do"); // Redirect to login page
    }
}
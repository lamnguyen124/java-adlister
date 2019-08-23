import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/login")
public class LoginServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException
        if (!error.equals("") req.setAttribute("error", error);
    req.getRequestDispatcher("/login.jsp").forward(req,resp);

}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException
            <%
            if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile");
        } else {
    }
%>


}
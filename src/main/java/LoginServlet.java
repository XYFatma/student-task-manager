import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.mindrot.jbcrypt.BCrypt;


@WebServlet("/login")
public class LoginServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.html");
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();

        if (email == null || email.isBlank() || password == null || password.isBlank()) {
        	session.setAttribute("error", "fields");
            response.sendRedirect("login.html");
            return;
        }
 
        StudentManager sm = new StudentManager();
        Student student = sm.findByEmail(email.trim());
 
        if (student == null ||!BCrypt.checkpw(password, student.getPasswordHash())) {
                session.setAttribute("error", "credentials");
                response.sendRedirect("login.html");
                return;
            }
 
        HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate();
        }
        
        session = request.getSession(true);
        
        session.setAttribute("studentID", student.getStudentID());
        session.setAttribute("studentName", student.getName());
        session.setAttribute("studentEmail", student.getEmail());
 
        response.sendRedirect("index.html");
    }
}

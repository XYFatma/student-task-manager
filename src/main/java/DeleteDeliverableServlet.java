import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteTask")
public class DeleteDeliverableServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		int deliverableId = Integer.parseInt(request.getParameter("id"));
		
		TaskManager tm = new TaskManager();
		tm.deleteDeliverable(deliverableId);
		
		response.sendRedirect("viewTasks");
		
	}
}

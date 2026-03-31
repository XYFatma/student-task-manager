import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/editTask")
public class EditDeliverableServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		TaskManager tm = new TaskManager();
        Deliverable d = tm.getDeliverableById(id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<h1>Edit Task</h1>");
        
        out.println("<form action='editTask' method='post'>");
        
        out.println("<input type='hidden' name='id' value='" + d.getDeliverableID() + "'/>");
        
        out.println("<label>Title</label><br>");
        out.println("<input type='text' name='title' value='" + d.getTitle() + "'/><br><br>");

        out.println("<label>Due Date</label><br>");
        out.println("<input type='date' name='dueDate' value='" + d.getDueDate() + "'/><br><br>");

        out.println("<label>Description</label><br>");
        out.println("<textarea name='description'>" + d.getDescription() + "</textarea><br><br>");

        out.println("<button type='submit'>Submit</button>");
        out.println("</form>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        int deliverableId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dueDate = request.getParameter("dueDate");

        TaskManager tm = new TaskManager();
        Deliverable d = tm.getDeliverableById(deliverableId);
        d.setTitle(title);
        d.setDueDate(Date.valueOf(dueDate));
        d.setDescription(description);

        tm.updateDeliverable(d);

        response.sendRedirect("viewTasks");
    }
}


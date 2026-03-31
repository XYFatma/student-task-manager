import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/viewTasks")
public class ViewDeliverableServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		TaskManager tm = new TaskManager();
		
		List<Deliverable> task = tm.getAllDeliverables();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>All Tasks</h1>");
		
		if (task.isEmpty()) {
			out.println("<p>No tasks found.</p>");
			out.println("<a href='index.html'>Home Page</a>");
		} else {
			out.println("<table style='border-spacing: 15px'>");
			out.println("<tr>");
			out.println("<th>Title</th>");
			out.println("<th>Description</th>"); 
			out.println("<th>Due Date</th>");
			out.println("<th>Status</th>");
			out.println("</tr>");
			
			for (Deliverable d : task) {
				out.println("<tr>");
				out.println("<td>" + d.getTitle() + "</td>");
				out.println("<td>" + d.getDescription() + "</td>");
				out.println("<td>" + d.getDueDate() + "</td>");
				out.println("<td>" + d.getStatus() + "</td>");
			    out.println("<td><a href='editTask?id=" + d.getDeliverableID() + "'>Edit</a></td>");
			    out.println("<td><a href='deleteTask?id=" + d.getDeliverableID() + "'>Delete</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href='index.html'>Home Page</a>");
		}
	}

}

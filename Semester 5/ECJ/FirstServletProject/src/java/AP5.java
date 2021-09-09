import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class AP5 extends HttpServlet {
    
    TreeMap<String, Integer> items = new TreeMap<>();
    float max = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AP5</title>");            
            out.println("</head>");
            out.println("<body>");  
            out.println("<table>");
            out.println("<thead><tr><th>Food Item</th><th></th><th>Vote Count</th></tr></thead>");
            for(Map.Entry<String, Integer> item: items.entrySet()){
                out.println("<tr>");
                out.println("<td style='border-right: 1px solid black; padding-right: 5px; text-align:center'>" + item.getKey().toUpperCase() + "</td>");
                out.println(String.format("<td><div style='padding-top:2px; background-color:red; width:%fpx'></div></td>", ((float)item.getValue()/max)*500));
                out.println("<td style='text-align:center;'>" + item.getValue() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] foodItems = request.getParameterValues("food");
        if(foodItems!=null)
            for(String food: foodItems){
                int c = items.getOrDefault(food, 0) + 1;
                items.put(food, c);
                max = Math.max(max, c);
            }
        response.sendRedirect("AP5.html");
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

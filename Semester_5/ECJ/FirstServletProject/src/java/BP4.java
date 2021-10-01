import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

public class BP4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB db = DB.getObject();
        ResultSet rs = db.getNurseData();
        try{
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Nurse Data</title>");
            out.println("<style>table,th,td{border: 1px solid black; padding: 5px;}</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Nurse Data</h2>");
            out.println("<table>");
            out.println("<thead><th>ID</th><th>Name</th><th>Duty Start</th><th>Duty End</th></thead>");
            while(rs.next()){
                out.println(String.format(
                    "<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                    rs.getString("nurse_id"), rs.getString("name"),
                    rs.getTime("duty_start").toString(), rs.getTime("duty_end").toString()
                ));
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
        catch(Exception e){}
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

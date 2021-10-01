import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AP1 extends HttpServlet {
    
    int count;
    
    public void init() {
        try{
            FileReader fr = new FileReader("AP1_count.txt");
            BufferedReader br = new BufferedReader(fr);
            count = Integer.parseInt(br.readLine().trim());
            br.close();
            fr.close();
        }
        catch(Exception e){}
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        count++;
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AP1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Visited Count: " + count + "</h2>");
        }
    }
    
    public void destroy(){
        try{
            FileWriter fw = new FileWriter("AP1_count.txt");
            fw.write(Integer.toString(count));
            fw.close();
        }catch(IOException e){}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
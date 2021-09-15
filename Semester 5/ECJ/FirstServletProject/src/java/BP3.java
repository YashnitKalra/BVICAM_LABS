import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class BP3 extends HttpServlet {
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
        response.setContentType("image/png");
        
        File file = new File("/home/yashnit/Downloads/image.png");
        response.setContentLength((int)file.length());
        response.setHeader("Content-Disposition", "attachment");
        
        FileInputStream fis = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf)) >= 0){
            out.write(buf);
        }
        fis.close();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part img = request.getPart("image");
        img.write("image.png");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>File Uploaded</h1>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

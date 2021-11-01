/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cmp.myCustomer;
import cmp.myCustomerFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yashnit
 */
public class addCustomerServlet extends HttpServlet {

    @EJB
    private myCustomerFacadeLocal myCustomerFacade;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String submit = request.getParameter("submit");
        
        if(submit.equals("Display")){
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><head><title>Customers</title><style>body{background-color: #cbcbcb;} table,th,td{border: 1px solid #000000; padding: 3px;}</style></head><body>");
                out.println("<table><tr><th colspan='4'>Total Records: " + myCustomerFacade.count() + "</th></tr><tr><th>ID</th><th>Name</th><th>Age</th><th>Gender</th></tr>");
                List<myCustomer> customers = myCustomerFacade.findAll();
                for(myCustomer c: customers){
                    out.println(String.format("<tr><td>%d</td><td>%s</td><td>%d</td><td>%s</td></tr>", c.getId(), c.getName(), c.getAge(), c.getGender()));
                }
                out.println("</table></body></html>");
            }
        }
        else if(submit.equals("Delete")){
            long id = Long.parseLong(request.getParameter("id"));
            myCustomerFacade.remove(myCustomerFacade.find(id));
        }
        else{
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            char gender = request.getParameter("gender").charAt(0);

            if(submit.equals("Add")){
                myCustomer c = new myCustomer();
                c.setAge(age);
                c.setGender(gender);
                c.setName(name);
                myCustomerFacade.create(c);
            }
            else{
                long id = Long.parseLong(request.getParameter("id"));
                myCustomer c = myCustomerFacade.find(id);
                c.setAge(age);
                c.setGender(gender);
                c.setName(name);
                myCustomerFacade.edit(c);
            }
        }
        
        if(!submit.equals("Display"))
            response.sendRedirect("index.html");
    }

}

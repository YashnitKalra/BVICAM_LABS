import bank.BankBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bank extends HttpServlet {

    BankBeanLocal bankBean = lookupBankBeanLocal();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        double amount;
        
        try (PrintWriter out = response.getWriter()) {
            try{
                switch(request.getParameter("operation")){
                    case "0":
                        amount = Double.parseDouble(request.getParameter("amount"));
                        if(bankBean.deposit(amount))
                            out.println("<h2 style='color:green'>Money Deposited Successfully!!</h2>");
                        else
                            out.println("<h2 style='color:red'>Error: Invalid Amount</h2>");
                        break;
                    case "1":
                        amount = Double.parseDouble(request.getParameter("amount"));
                        if(bankBean.withdraw(amount))
                            out.println("<h2 style='color:green'>Money Withdrawn Successfully!!</h2>");
                        else
                            out.println("<h2 style='color:red'>Error: Insufficient Amount / Invalid Amount</h2>");
                        break;
                    case "2":
                        out.println("<h2>Your Bank Balance is Rs. <i>"+ bankBean.balance() +"</i></h2>");
                        break;
                }
            }catch(Exception e){
                out.println("<h2 style='color:red'>Error: Invalid Amount</h2>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private BankBeanLocal lookupBankBeanLocal() {
        try {
            Context c = new InitialContext();
            return (BankBeanLocal) c.lookup("java:global/BankEnterpriseApplication/BankEnterpriseApplication-ejb/BankBean!bank.BankBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}

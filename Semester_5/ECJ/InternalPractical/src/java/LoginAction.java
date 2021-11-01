/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author yashnit
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success", FAILURE = "failure";
    private String user = "postgres", password = "root", url = "jdbc:postgresql://localhost/wt";
    private static Connection conn;

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        LoginForm formBean = (LoginForm)form;
        String email = formBean.getEmail();
        String pass = formBean.getPassword();
        
        if(conn==null){
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(url, user, password);
        }
        int count = 0;
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE email=? AND password=?;");
            pst.setString(1, email);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("count");
            rs.close();
            pst.close();
        }catch(Exception e){}
        
        if(count!=1){
            return mapping.findForward(FAILURE);
        }
        
        return mapping.findForward(SUCCESS);
    }
}

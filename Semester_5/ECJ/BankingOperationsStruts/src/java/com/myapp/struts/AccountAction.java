/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author yashnit
 */
public class AccountAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "performOperation";
    private static String errorString = "<span style='color:red; font-weight:bold'>%s</span>";
    private static String successString = "<span style='color:green; font-weight:bold'>%s</span>";

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
        Account account = (Account)form;
        double amount;
        if(account.getBalance()==null)
            account.setBalance(0);
        
        try{
            switch(account.getOperation()){
                case "deposit":
                    amount = Double.parseDouble(account.getMoney());
                    if(amount<0)
                        throw new NumberFormatException();
                    account.setBalance(account.getBalance() + amount);
                    account.setMsg(String.format(successString, "Money Depositted Successfully"));
                    break;
                case "withdraw":
                    amount = Double.parseDouble(account.getMoney());
                    if(amount<0)
                        throw new NumberFormatException();
                    else if(amount > account.getBalance()){
                        account.setMsg(String.format(errorString, "Insufficient Balance"));
                        break;
                    }
                    account.setBalance(account.getBalance() - amount);
                    account.setMsg(String.format(successString, "Money Withdrawn Successfully"));
                    break;
                case "balance":
                    account.setMsg(String.format(successString, "Your account balance is Rs. " + account.getBalance() ));
                    break;
                default:
                    account.setMsg(String.format(errorString, "Invalid Operation"));
            }
        }
        catch(NumberFormatException e){
            account.setMsg(String.format(errorString, "Invalid Amount"));
        }
        catch(NullPointerException e){
            account.setMsg(String.format(errorString, "Invalid Data"));
        }
        
        
        return mapping.findForward(SUCCESS);
    }
}

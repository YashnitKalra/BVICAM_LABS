/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP1;

/**
 *
 * @author yashnit
 */
public class MessageUtility {
    private String msg;
    MessageUtility(String msg){
        this.msg = msg;
    }
    
    String showMessage(){
        System.out.println(msg);
        return msg;
    }
}

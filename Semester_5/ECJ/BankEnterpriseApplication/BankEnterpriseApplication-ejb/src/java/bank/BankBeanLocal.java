/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import javax.ejb.Local;

/**
 *
 * @author yashnit
 */
@Local
public interface BankBeanLocal {

    boolean deposit(double amount);

    boolean withdraw(double amount);

    double balance();
    
}

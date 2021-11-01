/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author yashnit
 */
@Local
public interface myCustomerFacadeLocal {

    void create(myCustomer myCustomer);

    void edit(myCustomer myCustomer);

    void remove(myCustomer myCustomer);

    myCustomer find(Object id);

    List<myCustomer> findAll();

    List<myCustomer> findRange(int[] range);

    int count();
    
}

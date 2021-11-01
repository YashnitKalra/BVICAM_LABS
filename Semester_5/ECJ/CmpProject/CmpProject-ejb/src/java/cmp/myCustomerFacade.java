/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yashnit
 */
@Stateless
public class myCustomerFacade extends AbstractFacade<myCustomer> implements myCustomerFacadeLocal {

    @PersistenceContext(unitName = "CmpProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public myCustomerFacade() {
        super(myCustomer.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yashnit
 */
import java.util.*;

public class ProductRepository {
    private Map<Integer, Product> pr;
    
    ProductRepository(){
        pr = new HashMap<>();
    }
    
    boolean addProduct(Product product){
        if(pr.containsKey(product.getId()))
            return false;
        pr.put(product.getId(), product);
        return true;
    }
    
    boolean deleteProduct(int id){
        if(!pr.containsKey(id))
            return false;
        pr.remove(id);
        return true;
    }
    
    boolean updateProduct(int id, Product product){
        if(!pr.containsKey(id) || id!=product.getId())
            return false;
        pr.put(id, product);
        return true;
    }
}

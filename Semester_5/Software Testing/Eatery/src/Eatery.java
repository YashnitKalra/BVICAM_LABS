/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yashnit
 */
public class Eatery {
    int calculateBill(int billAmount, boolean isPickedUp){
        return billAmount + (isPickedUp?0:10);
    }
}

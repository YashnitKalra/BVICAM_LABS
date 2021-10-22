/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yashnit
 */
public class CoffeeMaker {
    private int power, pressure, capacity;

    public CoffeeMaker(int power, int pressure, int capacity) {
        this.power = power;
        this.pressure = pressure;
        this.capacity = capacity;
    }
    
    boolean isCoffeeMakerWorking(){
        return (power>=500 && pressure>=10 && pressure<=25 && capacity>0);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yashnit
 */
public class Square {
    private double side;
    Square(double sideLength){
        side = sideLength;
    }
    
    public double getArea(){
        return side*side;
    }
}

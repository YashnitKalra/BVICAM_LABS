package ejbappclient;

import ecj.ArithmeticBeanRemote;
import javax.ejb.EJB;

public class Main {

    @EJB
    private static ArithmeticBeanRemote arithmeticBean;

    public static void main(String[] args) {
        int a = 10, b = 5;
        int sum, dif, mul, div;
        
        sum = arithmeticBean.addition(a, b);
        dif = arithmeticBean.subtraction(a, b);
        mul = arithmeticBean.multiply(a, b);
        div = arithmeticBean.divide(a, b);
        
        System.out.println(String.format("Addition: %d\nSubtration: %d\nMultiplication: %d\nDivision: %d", sum, dif, mul, div));
        
        
    }
    
}

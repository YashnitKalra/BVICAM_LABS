package ecj;

import javax.ejb.Stateless;

@Stateless
public class ArithmeticBean implements ArithmeticBeanRemote {
    
    @Override
    public int addition(int a, int b){
        return a+b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a-b;
    }

    @Override
    public int multiply(int a, int b) {
        return a*b;
    }

    @Override
    public int divide(int a, int b) {
        return a/b;
    }
    
    
    
}

package ecj;

import javax.ejb.Remote;

@Remote
public interface ArithmeticBeanRemote {
    
    int addition(int a, int b);

    int subtraction(int a, int b);

    int multiply(int a, int b);

    int divide(int a, int b);
    
}

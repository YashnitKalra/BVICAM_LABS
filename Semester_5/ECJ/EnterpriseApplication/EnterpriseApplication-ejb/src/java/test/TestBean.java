package test;

import javax.ejb.Stateless;

@Stateless
public class TestBean implements TestBeanLocal {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    
    
}

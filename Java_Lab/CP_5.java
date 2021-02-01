class Electronics{
    static class Television{
        float price;
        static float staticPrice;
        Television(float p){price = p; staticPrice=p;}
        void cost(){System.out.printf("Using non-static Cost is %f\n", price);}
        static void staticCost(){System.out.printf("Using static Cost is %f\n", staticPrice);}
    }
}

public class CP_5 {
    public static void main(String[] args){
        Electronics.Television t = new Electronics.Television(20f);
        t.cost();
        Electronics.Television.staticCost();
    }
}

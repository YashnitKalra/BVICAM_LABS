class Waffle{
    String flavor;
    double price;
    Waffle(String flavor, double price){
        this.flavor = flavor;
        this.price = price;
    }
}

class WaffleMain extends Waffle{
    WaffleMain(String flavor, double price){
        super(flavor, price);
    }
    public boolean equals(Waffle obj){
        return this.flavor.equals(obj.flavor) && this.price==obj.price;
    }
    public String toString(){
        return "The price of flavor "+flavor+" is $"+price;
    }
}

public class BP_3 {
    public static void main(String[] args){
        WaffleMain wm1 = new WaffleMain("Chocolate", 50);
        WaffleMain wm2 = new WaffleMain("Vanilla", 40);
        System.out.println(wm1);
        System.out.println(wm2);
        System.out.println("The waffles are"+(wm1.equals(wm2)?" ":" not ")+"same");
    }
}

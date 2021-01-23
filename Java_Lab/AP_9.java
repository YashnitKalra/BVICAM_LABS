class FinancialCalculator{
    static void compute(double p, double r, double t){
        System.out.printf("Simple Interest: %f\n", (p*r*t)/100);
        System.out.printf("Compound Interest: %f\n", p*Math.pow(1 + r/100, t));
        System.out.printf("Final Value of Investment: %f\n", p*Math.pow(1+r, t));
    }
}

class AP_9{
    public static void main(String args[]){
        FinancialCalculator.compute(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
    }
}
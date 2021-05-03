import java.util.*;

class AA_2{
    public static void main(String[] args){
        System.out.print("Enter Double Value: ");
        double num = new Scanner(System.in).nextDouble();
        int numInteger = (int)num;
        double numRound = num-numInteger>=0.5?numInteger+1:numInteger;
        double numCeil = num-(double)numInteger==0?num:numInteger+1;
        double numFloor = numInteger;
        System.out.printf("Round Value: %f\nCeil Value: %f\nFloor Value: %f\n", numRound, numCeil, numFloor);
    }
}
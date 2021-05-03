import java.util.*;

class Product{
    int id; String name;
    Product(int id, String name){
        this.id = id; this.name = name;
    }
    static void printProductDetails(Product p[], int id){
        for(Product pro: p)
            if(pro.id==id)
                System.out.printf("Product ID: %d, Product Name: %s\n", pro.id, pro.name);
    }
}

class Supplier{
    int id; String name;
    Supplier(int id, String name){
        this.id = id; this.name = name;
    }
    static void printSupplierDetails(Supplier s[], int id){
        for(Supplier supp: s)
            if(supp.id==id)
                System.out.printf("Supplier ID: %d, Supplier Name: %s\n", supp.id, supp.name);
    }
}

class Product_Supplier{
    int p_id, s_id;
    Product_Supplier(int p_id, int s_id){
        this.p_id = p_id; this.s_id = s_id;
    }
    static void printProductsBySupplierId(int s_id, Product_Supplier prodSupp[], Product product[]){
        for(Product_Supplier ps: prodSupp)
            if(ps.s_id == s_id)
                Product.printProductDetails(product, ps.p_id);
    }
    static void printSuppliersByProductId(int p_id, Product_Supplier prodSupp[], Supplier supplier[]){
        for(Product_Supplier ps: prodSupp)
            if(ps.p_id == p_id)
                Supplier.printSupplierDetails(supplier, ps.s_id);
        }
}

class BP_9{
    public static void main(String[] args){
        Product products[] = {new Product(1, "Soap"), new Product(2, "Perfume"), new Product(3, "Pen"), new Product(4, "Clock")};
        Supplier suppliers[] = {new Supplier(1, "ABC"), new Supplier(2, "PQR"), new Supplier(3, "XYZ")};
        Product_Supplier product_supplier[] = {
            new Product_Supplier(1, 1), new Product_Supplier(4, 1),
            new Product_Supplier(2, 2), new Product_Supplier(1, 2),
            new Product_Supplier(3, 3), new Product_Supplier(1, 3)
        };
        Scanner obj = new Scanner(System.in);
        int choice;
        do{
            System.out.print("1. Get Suppliers from Product ID\n2. Get Products from Supplier ID\n3. Exit\nEnter choice: ");
            choice = obj.nextInt();
            if(choice==1){
                System.out.print("Enter Product ID: ");
                Product_Supplier.printSuppliersByProductId(obj.nextInt(), product_supplier, suppliers);
            }else if(choice==2){
                System.out.print("Enter Supplier ID: ");
                Product_Supplier.printProductsBySupplierId(obj.nextInt(), product_supplier, products);
            }
            System.out.println();
        }while(choice!=3);
    }
}
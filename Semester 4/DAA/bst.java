import java.util.Scanner;

class BinarySearchTreeNode{
    int val;
    BinarySearchTreeNode left, right;

    BinarySearchTreeNode(int data){
        val = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree{
    private BinarySearchTreeNode root;
    
    BinarySearchTree(){
        root = null;
    }

    void insertElement(int val){
       root = insertNode(val, root);
    }

    void deleteElement(int val){
        root = deleteNode(val, root);
    }
    
    boolean searchElement(int val){
        return searchNode(val, root)==null?false:true;
    }

    void printPreOrder(){
        preOrder(root); System.out.println();
    }

    void printInOrder(){
        inOrder(root); System.out.println();
    }

    void printPostOrder(){
        postOrder(root); System.out.println();
    }

    private BinarySearchTreeNode insertNode(int val, BinarySearchTreeNode root){
        if(root==null)
            return new BinarySearchTreeNode(val);
        else if(val < root.val)
            root.left = insertNode(val, root.left);
        else
            root.right = insertNode(val, root.right);
        return root;
    }

    private BinarySearchTreeNode deleteNode(int val, BinarySearchTreeNode root){
        if(root==null)
            return null;
        if(root.val == val){
            if(root.left==null && root.right==null) // no child
                return null;
            else if(root.left==null)    // only right child
                return root.right;
            else if(root.right==null)   // only left child
                return root.left;

            // both left and right are present
            BinarySearchTreeNode temp = root.right;
            while(temp.left!=null)
                temp = temp.left;
            root.val = temp.val;
            root.right = deleteNode(root.val, root.right);
        }
        else if(val < root.val)
            root.left = deleteNode(val, root.left);
        else
            root.right = deleteNode(val, root.right);
        return root;
    }

    private BinarySearchTreeNode searchNode(int val, BinarySearchTreeNode root){
        if(root==null || root.val==val)
            return root;
        if(val < root.val)
            return searchNode(val, root.left);
        return searchNode(val, root.right);
    }

    private void preOrder(BinarySearchTreeNode root){
        if(root==null) return;
        System.out.print(" " + root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(BinarySearchTreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(" " + root.val);
        inOrder(root.right);
    }

    private void postOrder(BinarySearchTreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.val);
    }
}

class bst{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        int choice;
        BinarySearchTree b = new BinarySearchTree();
        do{
            System.out.print("\n1. Create Tree\n2. Insert Element\n3. Delete Element\n4. Search Element\n5. Print Preorder\n6. Print Inorder\n7. Print Postorder\n\nEnter Choice: ");
            choice = obj.nextInt();
            switch(choice){
                case 1:
                    b = new BinarySearchTree(); System.out.println("NEW BST CREATED."); break;
                case 2:
                    System.out.print("Enter element to insert: ");
                    b.insertElement(obj.nextInt()); break;
                case 3:
                    System.out.print("Enter element to delete: ");
                    b.deleteElement(obj.nextInt()); break;
                case 4:
                    System.out.print("Enter element to search: ");
                    System.out.println("Element " + (b.searchElement(obj.nextInt())?"Found":"Not Found")); break;
                case 5:
                    System.out.print("Pre Order:");
                    b.printPreOrder(); break;
                case 6:
                    System.out.print("Inorder:");
                    b.printInOrder(); break;
                case 7:
                    System.out.print("Post Order:");
                    b.printPostOrder(); break;
            }
        }while(choice>0 && choice<8);
        obj.close();
    }
}
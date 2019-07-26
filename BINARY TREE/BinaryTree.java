/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author Dit
 */
public class BinaryTree {

//    class untuk mengisi data dari kiri ke kanan
    class Node{
        int key;
        Node left, right;
        
        public Node(int item){
            key = item;
            left = right = null;
        }
    }
    
    Node root;
    
//    Method untuk memasukan data dengan memanfaatkan fungsi rekrusif(memanggil diri sendiri)
    Node insertRec(Node root, int key){
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key)
        {
            root.left = insertRec(root.left, key);           
        }
        else if (key > root.key)
        {
            root.right = insertRec(root.right, key);  
        }
        return root;
    }
    
    void insert(int key){
        root = insertRec(root, key);
    }
    
//    Konstruktor tree
    BinaryTree(){
        root = null;
    }
    
    void inorderRec(Node root){
        if (root != null)
        {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    
    void inorder()
    {
        inorderRec(root);
    }
    
//    eksekusi program
    public static void main(String[] args) {
        
        BinaryTree pohon = new BinaryTree();
        
//        contohnya kita akan memasukan angka secara acak
        pohon.insert(6);
        pohon.insert(8);
        pohon.insert(4);
        pohon.insert(2);
        pohon.insert(1);
        pohon.insert(9);
        pohon.insert(3);
//        hasilnya data akan terurutkan
        pohon.inorder();
    }
    
}

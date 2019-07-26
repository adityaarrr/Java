/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinked;

/**
 *
 * @author Dit
 */
public class DoubleLinked {

    Node head;
    
    class Node {
        int data;
        Node next;
        Node prev;
        
        Node(int d)
        {
            data = d;
        }
    }
    
    public void push(int new_data)
    {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        new_Node.prev = null;
        if (head != null)
        {
            head.prev = new_Node;
        }
        head = new_Node;
    }
    
    public void InsertAfter(Node prev_Node, int new_data)
    {
        if(prev_Node == null)
        {
            System.out.println("Prev node tidak boleh kosong");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_Node.next;
        prev_Node.next = new_node;
        new_node.prev = prev_Node;
        if(new_node.next != null)
        {
            new_node.next.prev = new_node;
        }
    }
    
    void append(int new_data)
    {
        Node new_node = new Node(new_data);
        Node last = head;
        new_node.next = null;
        
        if(head == null)
        {
            new_node.prev = null;
            head = new_node;
            return;
        }
        
        while (last.next !=null )
        {
            last = last.next;
        }
        last.next = new_node;
        new_node.prev = last;
    }
    
    public void printlist(Node node)
    {
        Node last = null;
        System.out.println("Traverse dengan alur maju");
        while (node != null)
        {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println(" ");
        System.out.println("Traverse dengan alur mundur");
        while (last != null)
        {
            System.out.print(last.data + " ");
            last = last.prev;
        }
 
    }
    
//    eksekusi program
    public static void main(String[] args) {
        DoubleLinked doub = new DoubleLinked();
        doub.append(7);
        doub.push(2);
        doub.push(5);
        doub.append(4);
        doub.InsertAfter(doub.head.next, 9);
        
        System.out.println("Hasil dari Double Linked List adalah : ");
        doub.printlist(doub.head);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalinkedlist;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Dit
 */
public class JavaLinkedList {
    
    class node  
    { 
        int val; 
        node next; 
        public node(int val)  
        { 
            this.val = val; 
        } 
    } 
      
    node head1, head2, result; 
    int carry; 
  
    /* fungsi untuk push angka ke linked list */
    void push(int val, int list)  
    { 
        node newnode = new node(val); 
        if (list == 1)  
        { 
            newnode.next = head1; 
            head1 = newnode; 
        }  
        else if (list == 2)  
        { 
            newnode.next = head2; 
            head2 = newnode; 
        }  
        else 
        { 
            newnode.next = result; 
            result = newnode; 
        } 
  
    } 
  
    // Menambahkan dua linked list dengan ukuran yang sama diwakili oleh
    // head1 dan head2 dan kembali ke head sebagai hasil linked list  
    void addsamesize(node n, node m)  
    { 
        if (n == null) 
            return; 
  
        // Menambahkan node yang tersisa secara rekursif (memanggil diri sendiri)
        addsamesize(n.next, m.next); 
  
        int sum = n.val + m.val + carry; 
        carry = sum / 10; 
        sum = sum % 10; 
   
        push(sum, 3); 
  
    } 
  
    node cur; 
  
    void propogatecarry(node head1)  
    { 
        if (head1 != cur)  
        { 
            propogatecarry(head1.next); 
            int sum = carry + head1.val; 
            carry = sum / 10; 
            sum %= 10; 
  
            push(sum, 3); 
        } 
    } 
  
    int getsize(node head)  
    { 
        int count = 0; 
        while (head != null)  
        { 
            count++; 
            head = head.next; 
        } 
        return count; 
    } 
  
    // Fungsi utama yang menambahkan dua nilai ke linked list
    // yg diwakili oleh head1 dan head2. Jumlahnya dua
    // daftar disimpan kedalam list
    void addlists()  
    { 
        // cek jika head kosong
        if (head1 == null)  
        { 
            result = head2; 
            return; 
        } 
        // cek list pertama apakah kosong
        if (head2 == null)  
        { 
            result = head1; 
            return; 
        } 
        int size1 = getsize(head1); 
        int size2 = getsize(head2); 
        // Menmbahkan size yg sama
        if (size1 == size2)  
        { 
            addsamesize(head1, head2); 
        }  
        else 
        { 
            // node pertama harus lebih besar dari yang kedua 
            // jika tidak, maka pointer akan bertukar 
            if (size1 < size2)  
            { 
                node temp = head1; 
                head1 = head2; 
                head2 = temp; 
            } 
            int diff = Math.abs(size1 - size2); 
            node temp = head1; 
            while (diff-- >= 0)  
            { 
                cur = temp; 
                temp = temp.next; 
            } 
            addsamesize(cur, head2); 
            propogatecarry(head1); 
        } 
            if (carry > 0) 
                push(carry, 3); 
          
    } 
    
    // fungsi untuk print linked list 
    void cetak(node head)  
    { 
        System.out.print("Hasil Penjumlahan  =  ");
        while (head != null)  
        { 
            System.out.print(head.val + "  "); 
            head = head.next; 
        } 
    } 
    
    public static void main(String[] args) {
        JavaLinkedList list = new JavaLinkedList(); 
        list.head1 = null; 
        list.head2 = null; 
        list.result = null; 
        list.carry = 0; 
        Scanner input = new Scanner(System.in);
        System.out.println("Masukan Nilai Array 1 : ");
        int arr1[]=new int[5]; // Inisialisasi array dengan 5 index
        for (int i=0;i<5;i++) // loop nilai yg masuk
        {
                arr1[i]=input.nextInt(); // memasukan nilai kedalam array
        }
        System.out.println("Masukan Nilai Array 2 : ");
        int arr2[]=new int[5]; // Inisialisasi array dengan 5 index
        for (int i=0;i<5;i++) // loop nilai yg masuk
        {
                arr2[i]=input.nextInt(); // memasukan nilai kedalam array
        }
        for (int i = arr1.length - 1; i >= 0; --i) 
        list.push(arr1[i], 1); 

        for (int i = arr2.length - 1; i >= 0; --i) 
        list.push(arr2[i], 2); 

        list.addlists();
        System.out.println("Nilai pada array 1 = " + Arrays.toString(arr1));
        System.out.println("Nilai pada array 2 = " + Arrays.toString(arr2));
        System.out.println("                     ━━━━━━━━━━ +");
        list.cetak(list.result); 
    }
    
}

import java.util.*;
public class DsaToolkit {
    static Scanner sc = new Scanner(System.in);

    // ====== Singly Linked List ======
    static class LinkedList {
        class Node { 
            int data;
            Node next;
              Node(int d){
                data=d;
            } 
        } 
        private Node head;
        private int size=0;
        public void addFirst(int x){
             Node n=new Node(x);
             n.next=head;
             head=n; 
             size++; 
         }
        public void addLast(int x){
             Node n=new Node(x); 
             if(head==null){
                head=n;
                size++; 
                return;
            } 
            Node t=head; 
            while(t.next!=null)
            t=t.next; 
            t.next=n; 
            size++; 
        }
        public int removeFirst(){
             if(head==null) 
             return Integer.MIN_VALUE;
              int v=head.data;
               head=head.next;
                size--;
                 return v;
        }
        public void reverse(){
             Node prev=null;
             Node cur=head;
              while(cur!=null){
                 Node nxt=cur.next;
                  cur.next=prev; 
                   prev=cur; 
                   cur=nxt;
                } 
                head=prev; 
        }
        public void display(){
             Node t=head;
              System.out.print("LinkedList: "); 
              while(t!=null){
                 System.out.print(t.data+" -> ");
                  t=t.next; 
                } 
                System.out.println("null"); 
            }
        public int size(){
             return size; 
        }
    }
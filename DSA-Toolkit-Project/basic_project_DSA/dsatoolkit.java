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

    
    // ====== Stack (array) ======
    static class StackArr {
        int[] a; 
        int top=-1;
        StackArr(int cap){
             a=new int[cap];
         }
        public void push(int x){
             if(top+1==a.length) {
                 System.out.println("Stack Overflow");
                  return;
                } 
                a[++top]=x;
            }
        public int pop(){
             if(top==-1) {
                 System.out.println("Stack Empty");
                  return Integer.MIN_VALUE; 
                } 
                return a[top--];
             }
        public int peek(){ 
            if(top==-1)
             return Integer.MIN_VALUE;
              return a[top];
             }
        public boolean isEmpty(){
             return top==-1; 
            }
    }

     // ====== Queue (circular array) ======
    static class CircularQueue{
        int[] a; int head=0, tail=0, size=0;
        CircularQueue(int cap){ 
             a=new int[cap]; }
        public void offer(int x){ 
            if(size==a.length){
                 System.out.println("Queue Full"); 
                 return;
                } 
                a[tail]=x; 
                tail=(tail+1)%a.length;
                 size++;
                 }
        public int poll(){
             if(size==0){
                 System.out.println("Queue Empty");
                  return Integer.MIN_VALUE;
                } 
                int v=a[head]; 
                head=(head+1)%a.length;
                 size--; 
                 return v; }
        public int peek(){
             if(size==0) return Integer.MIN_VALUE; 
             return a[head];
             }
    }

    // ====== Binary Search Tree ======
    static class BST{
        class Node{ int val; Node left,right; Node(int v){val=v;} }
        Node root;
        public void insert(int v){
             root = insertRec(root,v);
             }
        private Node insertRec(Node node,int v){
             if(node==null) 
                return new Node(v);
             if(v<node.val) 
                node.left=insertRec(node.left,v);
             else 
                node.right=insertRec(node.right,v); 
            return node; 
        }
        public boolean search(int v){
             return searchRec(root,v); 
            }
        private boolean searchRec(Node node,int v){
             if(node==null) 
                return false; 
            if(node.val==v) 
                return true; 
            if(v<node.val) 
                return searchRec(node.left,v); 
            return searchRec(node.right,v);
         }
        public void inorder(){
             inorderRec(root); 
             System.out.println();
             }
        private void inorderRec(Node node){
             if(node==null) 
                return; 
            inorderRec(node.left); 
            System.out.print(node.val+" "); 
            inorderRec(node.right);
         }
        public void delete(int v){
             root = deleteRec(root,v);
             }
        private Node deleteRec(Node node,int v){
             if(node==null) 
                return null; 
            if(v<node.val) 
                node.left=deleteRec(node.left,v); 
            else if(v>node.val) 
                node.right=deleteRec(node.right,v);
             else {
            if(node.left==null) 
                return node.right; 
            else if(node.right==null) 
                return node.left; 
            node.val = minValue(node.right); 
            node.right = deleteRec(node.right,node.val);
        } 
        return node; 
    }
        private int minValue(Node node){
             Node cur=node; 
             while(cur.left!=null)
                 cur=cur.left; 
                return cur.val; 
            }
    }

     // ====== Graph (adj list) with BFS/DFS ======
    static class Graph{
        int n; 
        ArrayList<Integer>[] adj;
        Graph(int n){ 
            this.n=n; 
            adj = new ArrayList[n]; 
            for(int i=0;i<n;i++) 
                adj[i]=new ArrayList<>(); 
            }
        void addEdge(int u,int v){
             adj[u].add(v);
             adj[v].add(u);
             }
        void bfs(int start){
    boolean[] vis = new boolean[n];
   Queue<Integer> q = new java.util.LinkedList<>(); // fixed line 
    q.add(start);
    vis[start] = true;
    System.out.print("BFS: ");
    while(!q.isEmpty()){
        int u = q.poll();
        System.out.print(u+" ");
        for(int w: adj[u]){
            if(!vis[w]){
                vis[w] = true;
                q.add(w);
            }
        }
    }
    System.out.println();
}

        void dfs(int start){
             boolean[] vis=new boolean[n]; 
             System.out.print("DFS: ");
             dfsRec(start,vis); 
             System.out.println(); 
        }
        void dfsRec(int u, boolean[] vis){ 
            vis[u]=true; 
            System.out.print(u+" "); 
            for(int w:adj[u]) 
                if(!vis[w]) 
                    dfsRec(w,vis);
        }
    }

    

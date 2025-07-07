import java.io.*;
import java.util.*;

class Node{
    char root;
    Node left;
    Node right;

    public Node(char root , Node left, Node right){
        this.root = root;
        this.left = left;
        this.right = right;
    }
}

public class Main {

    public static Node head = new Node('A',null,null);

    public static StringBuilder sb;

    public static void insert(Node head, char root, char l,char r){
        if(head.root == root){
            if(l!='.') head.left = new Node(l,null,null);
            if(r!='.') head.right = new Node(r,null,null);
        }
        else{
            if(head.left !=null) insert(head.left,root,l,r);
            if(head.right !=null) insert(head.right,root,l,r);
        }
    }

    public static void preOrder(Node head){
        if(head==null) return;
        sb.append(head.root);
        preOrder(head.left);
        preOrder(head.right);

    }
    public static void inOrder(Node head){
        if(head==null) return;
        inOrder(head.left);
        sb.append(head.root);
        inOrder(head.right);
    }
    public static void postOrder(Node head){
        if(head==null) return;
        postOrder(head.left);
        postOrder(head.right);
        sb.append(head.root);

    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb= new StringBuilder();

        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            insert(head,a,b,c);
        }

        preOrder(head);
        sb.append('\n');
        inOrder(head);
        sb.append('\n');
        postOrder(head);
        sb.append('\n');

        System.out.println(sb);
    }
}

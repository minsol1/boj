
import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[] students;
    
    public static class Node{
        int num;
        int recommand;
        Node next;
        
        Node(int num, int recommand){
            this.num = num;
            this.recommand = recommand;
            this.next = null;
        }
    }
    
    public static class SinglyLinkedList{
        private Node head;
        private int size;
        private int MAX_SIZE;
        
        public void init(int MAX_SIZE) {
            head = null;
            size = 0;
            this.MAX_SIZE = MAX_SIZE;
        }
        
        public Node get(int num) {
            Node newNode = head;
            
            while(newNode.next != null) {
                if(newNode.next.num == num)
                    break;
                
                newNode = newNode.next;
            }
            
            return newNode;
        }
        
        public void remove(int index) {
            Node newNode = head;
            
            // index의 앞
            for(int i = 0; i < index - 1; i++)
                newNode = newNode.next;
            
            // 가장 앞의 것을 제거하고자 할 때
            if(index == 0)
                // 사진틀이 하나면
                if(head.next == null)
                    head = null;
                // 사진틀이 여러 개면
                else
                    head = head.next;
            
            // 두 번째 사진틀을 제거하고자 할 때
            else if(index == 1)
                head.next = head.next.next;
            
            // 그 외의 경우
            else
                newNode.next = newNode.next.next;
            
            size--;
        }
        
        public void add(int num) {
            
            if(head == null) {
                Node newNode = new Node(num, 1);
                head = newNode;
                size++;
            }
            
            else {
                // 가장 앞 사진틀이 현재 후보일 때 (get 함수의 한계)
                if(head.num == num) 
                    head.recommand += 1;
                // 사진틀에 후보가 없을 때
                else if(get(num).next == null) {
                    Node newNode = new Node(num, 1);
                    // 빈 사진틀이 없을 때
                    if(size == MAX_SIZE) {
                        Node temp = head;
                        int min = Integer.MAX_VALUE;
                        int tempIndex = 0;
                        int count = 0;
                        // 가장 투표수가 작으면서 오래된 사진틀 제거
                        while(temp != null) {
                            if(temp.recommand <= min) {
                                min = temp.recommand;
                                tempIndex = count;
                            }
                            count++;
                            temp = temp.next;
                        }
//                            System.out.println("삭제하려는 후보 순서" + tempIndex + " 투표 수 " + min);
                        remove(tempIndex);
                    }
                    newNode.next = head;
                    head = newNode;
                    size++;
                }
                // 사진틀에 후보가 있을 때
                else 
                    get(num).next.recommand += 1;
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        students = new int[M];
        List<Integer> outputs = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < M; i++)
            students[i] = Integer.parseInt(st.nextToken());
        
        SinglyLinkedList SLL = new SinglyLinkedList();
        
        SLL.init(N);
        
        for(int i = 0; i < M; i++)
            SLL.add(students[i]);
        
        Node outputNode = SLL.head;
        
        while(outputNode != null) {
            outputs.add(outputNode.num);
            outputNode = outputNode.next;
        }
        
        Collections.sort(outputs);
        StringBuilder sb = new StringBuilder();
        
        for(int i : outputs)
            sb.append(i).append(" ");
        
        System.out.println(sb);
    }

}

// 민솔 코드
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class Node{
//    int data; // 추천 수
//    Node next;
//    int num; // 학생 번호
//
//    public Node(int num) { // num 노드 생성
//        this.data = 1;
//        this.next = null;
//        this.num = num;
//    }
//
//}
//
//class LinkedList{
//    Node head;
//    Node tail;
//    int size;
//    int MAX_SIZE;
//    boolean[] arr; 
//
//    public LinkedList(int MAX_SIZE, int num) {
//        this.head= null;
//        this.tail = null;
//        this.size = 0;
//        this.MAX_SIZE = MAX_SIZE; 
//        this.arr = new boolean[num+1]; // 후보 존재 여부
//    }
//
//    public Node getNewNode(int num) { // 노드 생성
//        return new Node(num);
//    }
//    public Node get(int num) { // num이전 노드 반환 
//        Node cur = head;
//        while(cur.next !=null) {
//            if(cur.next.num == num) { // 다음 노드가num 이면 break
//                break;
//            }
//            cur = cur.next;
//        }
//        return cur;
//    }
//
//    public void add(int num) { //num 노드 add 
//
//        Node newNode;
//
//        // 추가할 노드 생성//
//
//        if(!arr[num]) { //존재 하지않는 후보면 노드 생성 
//            newNode = getNewNode(num);
//
//        }else { // 존재하는 후보 추가면  기존의 노드 삭제 , 투표수 +1 새노드 생성 
//            Node delNode = del(num);
//            newNode = getNewNode(num);
//            newNode.data = delNode.data+1;
//        }
//
//        if(size==MAX_SIZE) { //가득 찬 경우 마지막 삭제 
//
//            Node cur = head;
//
//            for(int i=1 ; i<size-1 ; i++) {
//                cur = cur.next;
//            }
//
//            arr[cur.next.num] = false;
//            cur.next = null;
//            tail = cur;
//            size --;
//
//        }
//
//        // 추가 
//
//        if (head==null) { // 리스트에 처음 올라가는 경우
//            head = newNode;
//            tail = newNode;
//        }
//        else {
//            if(newNode.data >=head.data) { // 젤 앞에 추가되는 경우
//                newNode.next = head;
//                head = newNode;
//            }
//            else if(tail.data> newNode.data) { // 마지막에 추가되는 경우
//                tail.next =newNode;
//                tail = newNode;
//            }
//            else { // 중간에 추가되는 경우
//                Node cur = head;
//
//                for(int i=1 ; i<size-1;i++) {
//
//                    if(newNode.data >=cur.next.data && cur.data>newNode.data) {
//                        newNode.next = cur.next;
//                        cur.next = newNode;
//                        break;
//                    }
//                    cur = cur.next;
//                }
//            }
//        }
//
//        size ++;
//        //추가 된 노드 존재 
//        arr[num]=true;
//
//    }
//
//    public Node del(int num) { // 번호가 num인 노드 삭제 , 삭제 노드 반환 
//        Node cur = get(num); // num 이전 노드 찾 
//        Node del= cur.next; // 삭제할 노드 
//        size--; // 사이즈 줄임 
//        arr[num] = false;// 리스트에서 삭제 
//
//        if(cur.next.next!=null) { // 삭제할 노드가 마지막 노드인 경우 
//            cur.next = null;
//            tail = cur;
//        }else {
//            cur.next = cur.next.next;
//        }
//
//        return del;
//    }
//
//
//}
//
//public class Main {
//    
//
//public static void main(String[] args) throws NumberFormatException, IOException {
//    // TODO Auto-generated method stub
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st;
//    
//    int N = Integer.parseInt(br.readLine()); //사진 틀 개수 
//    int M = Integer.parseInt(br.readLine()); // 추천 횟수
//
//    LinkedList li = new LinkedList(N,100); //크기가 N인 사진틀
//    
//    st = new StringTokenizer(br.readLine());
//    
//    for(int i=0;i<M;i++) {
//        li.add(Integer.parseInt(st.nextToken()));
//        
//    }
//    
//    
//    for(int i=0;i<101;i++) { // 사진틀에 존재하는 후보 출력
//        if(li.arr[i]) {
//            System.out.printf("%d ",i);
//        }
//    }
//}
//}
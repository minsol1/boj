import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int num;
    int[] score;
    int cnt;
    int total;
    int last;

    public Node(int num,int k){
        this.num = num;
        this.score = new int[k];
        this.cnt = 0;
        this.total = 0;
        this.last = 0;
    }

    @Override
    public int compareTo(Node o) {
        if(this.total == o.total){
            if(this.cnt == o.cnt){
                return this.last - o.last;
            }
            else{
                return this.cnt - o.cnt;
            }
        }
        else{
            return o.total - this.total;

        }
    }
}
public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //팀 수
            int K = Integer.parseInt(st.nextToken()); // 문제수
            int I = Integer.parseInt(st.nextToken()); // 팀 id
            int M = Integer.parseInt(st.nextToken()); // 로그 수

            Node[] arr = new Node[N];
            for(int i =1;i<N+1;i++){
                arr[i-1] = new Node(i,K);
            }

            for(int i =0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                if(arr[id-1].score[q-1]<s){
                    arr[id-1].total-=arr[id-1].score[q-1];
                    arr[id-1].total+=s;
                    arr[id-1].score[q-1] = s;
                }
                arr[id-1].cnt++;
                arr[id-1].last = i;
            }

            Arrays.sort(arr);

            for(int i =1;i<N+1 ; i++){
                Node n = arr[i-1];
//                System.out.println(n.num+" "+ n.total+" "+ n.cnt+" "+n.last);
                if(n.num==I){
                    System.out.println(i);
                    break;
                }
            }

        }
    }
}

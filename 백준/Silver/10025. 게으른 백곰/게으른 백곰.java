import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int g;
    int x;
    public Node(int g,int x){
        this.g = g;
        this.x = x;
    }

    public int compareTo(Node o){
        return x - o.x;
    }
}

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[N];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[i]= new Node(g,x);
        }
        Arrays.sort(arr);

        int l =0;
        int r = 0;
        int max =0;
        int sum =0;

        while(r<N){
            int a = arr[r].x - arr[l].x;
            if( a > 2*K){
                sum-=arr[l].g;
                l++;
            }
            else{
                sum+= arr[r].g;
                max = max>sum?max:sum;
                r++;
            }
        }

        System.out.println(max);
    }
}

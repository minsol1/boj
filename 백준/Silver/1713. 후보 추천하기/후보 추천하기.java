import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int num;
    int cnt;
    int id;

    public Node(int num,int cnt,int id){
        this.num = num;
        this.cnt = cnt;
        this.id = id;
    }

    @Override
    public int compareTo(Node o) {
        if(cnt == o.cnt){
            return o.id - id;
        }

        return o.cnt - cnt;
    }
}

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();
        boolean[] num = new boolean[101];
        int idx = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<M;i++){
            int n = Integer.parseInt(st.nextToken());

            if(!num[n]){
                if(arr.size()==N){
                    Collections.sort(arr);
                    num[arr.get(N-1).num]=false;
                    arr.remove(N-1);
                }
                arr.add(new Node(n,1,idx++));
                num[n]= true;
            }
            else{
                for(Node node : arr){
                    if(node.num == n){
                        node.cnt++;
                        break;
                    }
                }
            }

        }

        for(int i =1;i<101;i++){
            if(num[i]) System.out.print(i+" ");
        }
    }
}

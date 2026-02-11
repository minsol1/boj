
import java.io.*;
import java.util.*;

class Node{
    int num;
    char color;

    public Node(int num, char color){
        this.num = num;
        this.color = color;
    }
}

public class Main {

    public static int N, M, K;
    public static int[][] dp;
    public static ArrayList[] arr;
    public static char[] color;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i< N; i++){
            color[i] = st.nextToken().charAt(0);
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][M];
        arr = new ArrayList[M]; // 연결 정보
        for(int i =0; i< M; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i =0 ; i< N+1; i++){
            for(int j =0; j<M;j++){
                dp[i][j] = -1;
            }
        }

        for(int i =0; i< K ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            char c = st.nextToken().charAt(0);
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        dp[0][0] = 0;
        for(int i = 1; i <= N; i++){

            for(int j =0; j< M ; j++){

                for(int k = 0; k < arr[j].size(); k++){
                    Node node = (Node)arr[j].get(k);
                    if(dp[i-1][node.num] !=-1){
                        int score = dp[i-1][node.num];
                        if(color[i-1] == node.color){
                            score +=10;
                        }
                        if(dp[i][j] < score) dp[i][j] = score;
                    }
                }
            }

        }
        
        int res = 0;
        for(int i = 0; i < M; i++){
            if(res < dp[N][i]) res = dp[N][i];
        }
        System.out.println(res);

    }
}

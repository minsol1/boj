import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

    class Node implements Comparable<Node>{
        int score1;
        int score2;

        public Node(int score1,int score2){
            this.score1 =score1;
            this.score2 =score2;
        }

        @Override
        public int compareTo(Node o) {
            if(this.score1==o.score1){
                return this.score2-o.score2;
            }
            return this.score1-o.score1;
        }
    }
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T ;t++){
            int N = Integer.parseInt(br.readLine());
            int res = N;

            Node[] arr = new Node[N];
            StringTokenizer st;
            for(int i =0;i<N;i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[i]= new Node(a,b);
            }

            Arrays.sort(arr);

            int max_score = arr[0].score2;

            for(int i =1;i<N;i++){
                if(arr[i].score2>max_score){
                    res--;
                }
                else{
                    max_score = arr[i].score2;
                }
            }

            System.out.println(res);
        }

    }
}

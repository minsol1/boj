
import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N][20];
        HashSet<Integer> hs = new HashSet<>();

        for(int i =0; i< M ; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken()) -1;

            if(num == 1){
                int people = Integer.parseInt(st.nextToken())-1;
                arr[idx][people] = true;
            }
            else if(num ==2){
                int people = Integer.parseInt(st.nextToken())-1;
                arr[idx][people] = false;
            }
            else if(num ==3){
                for(int j = 19 ; j >0; j--){
                    arr[idx][j] = arr[idx][j-1];
                }
                arr[idx][0] = false;
            }
            else if(num ==4){
                for(int j = 0 ; j <19; j++){
                    arr[idx][j] = arr[idx][j+1];
                }
                arr[idx][19] = false;

            }
        }

        for(int i =0; i <N ; i++){
            int n = 0;
            for(int j = 0 ; j<20 ; j++){
                if(arr[i][j]){
                    n = (n<<1)+1;
                }
                else {
                    n = n<<1;
                }
            }
            hs.add(n);
        }

        System.out.println(hs.size());

    }
}

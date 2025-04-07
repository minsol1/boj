import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W= Integer.parseInt(st.nextToken());
        int res = 0;

        boolean[][] arr = new boolean[H][W];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<W ;i++){
            int n = Integer.parseInt(st.nextToken());

            for(int j = H-1;j>=H-n; j--){
                arr[j][i] = true;
            }
        }

        for(int i =0;i< H;i++){
            int c = 0;
            boolean f = false;
            for(int j =0;j<W; j++){
                if(!f && arr[i][j]){
                    f = true;
                    c =0;
                }
                else if(arr[i][j]){
                    res+=c;
                    c=0;
                }
                else{
                    c++;
                }
            }
        }

        System.out.print(res);

    }
}

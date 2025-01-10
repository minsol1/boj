import java.io.*;
import java.util.*;

public class Main {
    public static int check(boolean[][] arr){
        int n=0;
        for(int i =0;i<5;i++){
            int c =0;
            for(int j =0;j<5;j++){
                if(arr[i][j]){
                    c++;
                }
            }
            if(c==5) n++;
        }
        for(int i =0;i<5;i++){
            int c =0;
            for(int j =0;j<5;j++){
                if(arr[j][i]){
                    c++;
                }
            }
            if(c==5) n++;
        }

        int c =0;
        for(int i =0;i<5;i++){
            if(arr[i][i]){
                c++;
            }
            if(c==5) n++;
        }
        c =0;
        for(int i =4;i>=0;i--){
            if(arr[4-i][i]){
                c++;
            }
            if(c==5) n++;
        }
        return n;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] arr = new boolean[5][5];
        HashMap<Integer,int[]> pos = new HashMap<>();
        int res =0;

        StringTokenizer st;
        for(int i =0;i<5;i++){
            st =new StringTokenizer(br.readLine());

            for(int j =0;j<5;j++){
                int n = Integer.parseInt(st.nextToken());
                pos.put(n,new int[]{i,j});
            }
        }

        for(int i =0;i<5;i++){
            st =new StringTokenizer(br.readLine());
            int cnt =0;
            for(int j =0;j<5;j++){
                res ++;
                int n = Integer.parseInt(st.nextToken());
                int[] idx = pos.get(n);
                arr[idx[0]][idx[1]] = true;
                cnt = check(arr);
                if(cnt>=3){
                    break;
                }
            }
            if(cnt>=3){
                break;
            }
        }
        System.out.println(res);

    }
}

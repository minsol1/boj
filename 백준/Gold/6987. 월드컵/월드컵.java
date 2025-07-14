import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;
    public static boolean flag;

    public static void dfs(int idx,int nxt){
        if(flag) return;

        if(idx ==5){
            flag = true;
            return;
        }

        if(arr[idx][0]>0 && arr[nxt][2]>0){
            arr[idx][0]--;
            arr[nxt][2]--;

            if(nxt==5){
                dfs(idx+1,idx+2);
            }
            else dfs(idx,nxt+1);
            arr[idx][0]++;
            arr[nxt][2]++;
        }
        if(arr[idx][2]>0 && arr[nxt][0]>0){
            arr[idx][2]--;
            arr[nxt][0]--;

            if(nxt==5){
                dfs(idx+1,idx+2);
            }
            else dfs(idx,nxt+1);
            arr[idx][2]++;
            arr[nxt][0]++;
        }
        if(arr[idx][1]>0 && arr[nxt][1]>0){
            arr[idx][1]--;
            arr[nxt][1]--;

            if(nxt==5){
                dfs(idx+1,idx+2);
            }
            else dfs(idx,nxt+1);
            arr[idx][1]++;
            arr[nxt][1]++;
        }


    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int t =0;t<4;t++){
            arr = new int[6][3];
            flag = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0;i<6;i++){
                arr[i][0]=Integer.parseInt(st.nextToken());
                arr[i][1]=Integer.parseInt(st.nextToken());
                arr[i][2]=Integer.parseInt(st.nextToken());
                if(arr[i][0]+arr[i][1]+arr[i][2]!=5){
                    flag = false;
                }
            }
            if(flag){
                flag = false;
                dfs(0,1);
            }

            if(flag) System.out.print(1+" ");
            else System.out.print(0+" ");

        }
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static int N,M,res;
    public static int[][] arr;
    public static int [] dx = {0,1,0,-1};
    public static int [] dy = {1,0,-1,0};
    public static Queue<int[]> q;

    public static void bfs(){

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d =0;d<4;d++){
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

                if(arr[nx][ny]==0){
                    q.add(new int[]{nx,ny});
                    arr[nx][ny] = arr[now[0]][now[1]]+1;
                    res = res > arr[nx][ny]?res : arr[nx][ny];

                }

            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();
        res =1;
        arr = new int[N][M];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<M;j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) q.add(new int[]{i,j});
            }
        }

        bfs();

        res -=1;
        for(int[] a : arr){
            for(int n : a){
                if(n == 0) res = -1;
            }
        }
        System.out.println(res);

    }
}

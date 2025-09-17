import java.io.*;
import java.util.*;

public class Main {
    public static int N , M;
    public static char[][] arr;
    public static int[] dx  = {0,1,0,-1};
    public static int[] dy  = {1,0,-1,0};
    public static Queue<int[]> q1;
    public static Queue<int[]> q2;

    public static boolean bfs1(){
        Queue<int[]> q3 = new ArrayDeque<>();

        while(!q1.isEmpty()){
            int[] now = q1.poll();

            for(int d =0; d<4;d++){
                int nx = now[0]+ dx[d];
                int ny = now[1]+ dy[d];

                if(nx<0 || nx >=N || ny <0 || ny >= M) return true;
                if(arr[nx][ny]!= '.') continue;
                arr[nx][ny] = 'J';
                q3.add(new int[]{nx,ny});
            }
        }

        q1 = q3;

        return false;
    }

    public static void bfs2(){
        Queue<int[]> q3 = new ArrayDeque<>();

        while(!q2.isEmpty()){
            int[] now = q2.poll();

            for(int d =0; d<4;d++){
                int nx = now[0]+ dx[d];
                int ny = now[1]+ dy[d];

                if(nx<0 || nx >=N || ny <0 || ny >= M || arr[nx][ny]== '#' || arr[nx][ny]== 'F' ) continue;
                arr[nx][ny] = 'F';
                q3.add(new int[]{nx,ny});
            }
        }

        q2 = q3;

    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        q1 = new ArrayDeque<>();
        q2= new ArrayDeque<>();
        int res = -1;
        int m = 0;

        for(int i =0; i<N;i++){
            String str = br.readLine();
            for(int j =0;j<M;j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'J') {
                    q1.add(new int[]{i,j});
                }
                if(arr[i][j]== 'F') q2.add(new int[]{i,j});
            }
        }

        while(!q1.isEmpty()){
            m++;
            bfs2();
            if(bfs1()) {
                res = m;
                break;
            }
        }

        if(res == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(res);

    }
}

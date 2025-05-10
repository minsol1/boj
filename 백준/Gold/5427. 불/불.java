import java.util.*;
import java.io.*;

public class Main {

//    '.': 빈 공간
//    '#': 벽
//    '@': 상근이의 시작 위치
//    '*': 불

    public static int N,M,res;
    public static char[][] arr;
    public static int[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static Queue<int[]> q1;
    public static Queue<int[]> q2;
    public static Queue<int[]> q3;

    public static void bfs(){
        while(!q1.isEmpty()){
            q3 = new ArrayDeque<>();
            //불
            for(int[] now : q2){

                for(int d = 0;d<4;d++){
                    int nx = now[0]+dx[d];
                    int ny = now[1]+dy[d];

                    if(nx<0 || nx>=N || ny<0 || ny>=M || arr[nx][ny]!='.') continue;
                    arr[nx][ny] = '*';
                    q3.add(new int[]{nx,ny});

                }
            }
            q2 = q3;

            q3 = new ArrayDeque<>();

            for(int[] now : q1){
                for(int d = 0;d<4;d++){
                    int nx = now[0]+dx[d];
                    int ny = now[1]+dy[d];

                    if(nx<0 || nx>=N || ny<0 || ny>=M ){
                        res = visited[now[0]][now[1]]+1;
                        return;
                    }

                    if(arr[nx][ny]!='.' || visited[nx][ny]!=-1) continue;

                    visited[nx][ny]= visited[now[0]][now[1]]+1;
                    q3.add(new int[] {nx,ny});

                }
            }
            q1 = q3;

        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t =0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            res = -1;
            arr = new char[N][M];
            visited = new int[N][M];
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();

            for(int i =0;i<N;i++){
                for(int j =0;j<M;j++){
                    visited[i][j]= -1;
                }
            }

            for(int i =0;i<N;i++){
                String str = br.readLine();
                for(int j =0;j<M;j++){
                    arr[i][j] = str.charAt(j);
                    if(arr[i][j]=='@'){
                        q1.add(new int[]{i,j});
                        visited[i][j] = 0;
                    }
                    if(arr[i][j] == '*'){
                        q2.add(new int[]{i,j});
                    }
                }
            }
            bfs();

            if(res ==-1){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(res);
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] num;
    public static int[][] arr;
    public static int[][] map;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int res=0;

    public static void bfs(int n){
        int like=0;
        int empty=0;
        int x=-1;
        int y =-1;

        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==0){
                    if(x==-1 && y==-1){
                        x=i;
                        y=j;
                    }
                    int lcnt =cntLike(n,i,j);
                    int ecnt = cntEmpty(i,j);
                    if(lcnt>like){
                        x=i;
                        y=j;
                        like = lcnt;
                        empty = ecnt;
                    }
                    else if(lcnt == like && ecnt>empty){
                        x=i;
                        y=j;
                        empty = ecnt;
                    }

                }
            }
        }
        map[x][y] = n;


    }
    public static int cntLike(int n, int x, int y){
        int c=0;
        for(int d =0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if(map[nx][ny]== arr[n][0] ||map[nx][ny]== arr[n][2]||map[nx][ny]== arr[n][3]||map[nx][ny]== arr[n][1]){
                c++;
            }
        }
        return c;
    }
    public static int cntEmpty( int x, int y){
        int c=0;
        for(int d =0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if(map[nx][ny]== 0){
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N*N];
        arr= new int[N*N+1][4];
        map = new int[N][N];
        StringTokenizer st;
        for(int i =0;i<N*N;i++){
            st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
            for(int j=0;j<4;j++ ){
                arr[num[i]][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0;i<N*N;i++){
            bfs(num[i]);
        }

        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                int c = cntLike(map[i][j],i,j);
                if(c==1) res+=1;
                if(c==2) res+=10;
                if(c==3) res+=100;
                if(c==4) res+=1000;

            }
        }


        System.out.println(res);

    }
}

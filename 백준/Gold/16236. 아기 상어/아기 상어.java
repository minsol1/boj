import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Fish{
    int x;
    int y;
    int move;

    public Fish(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}

public class Main {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int N,posx,posy;
    public static int size;
    public static int res;
    public static int[] dx = {-1,0,0,1};
    public static int[] dy = {0,-1,1,0};

    public static void bfs(int x , int y){
        int eat = 0;
        while(true){
            Queue<Fish> q = new ArrayDeque<>();
            List<Fish> fishList = new ArrayList<>();
            visited = new boolean[N][N];
            visited[posx][posy] = true;
            q.add(new Fish(posx,posy,0));

        while (!q.isEmpty()){
            Fish now = q.poll();

            int nMove = now.move;

            for(int d =0;d<4;d++){
                int nx = now.x+dx[d];
                int ny = now.y+dy[d];

                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    continue;
                }

                if(!visited[nx][ny] && arr[nx][ny]<= size){

                    if(arr[nx][ny] < size && arr[nx][ny]!=0){
                        fishList.add(new Fish(nx,ny,nMove+1));
                    }
                    q.add(new Fish(nx,ny, nMove+1));
                    visited[nx][ny]= true;
                }
            }
        }
        if(fishList.size()==0){
            break;
        }
        else{
            if(fishList.size()>1){
                Collections.sort(fishList, new Comparator<Fish>() {
                    @Override
                    public int compare(Fish o1, Fish o2) {
                        // 1. 가장 가까운(move) 2. 가장 위 (x) , 3.가장 왼쪽(y)
                        if(o1.move == o2.move) {
                            if(o1.x == o2.x) {
                                // 가장 왼쪽
                                return o1.y-o2.y;
                            }else {
                                // 가장 위
                                return o1.x-o2.x;
                            }
                        }else {
                            // 가장 가까운 곳
                            return o1.move- o2.move;
                        }
                    }
                });
            }
            Fish eatFish = fishList.get(0);
            res += eatFish.move;
            eat++;

            arr[posx][posy] = 0;
            posx= eatFish.x;
            posy= eatFish.y;
            arr[posx][posy] = 9;

            if(size == eat){
                size++;
                eat = 0;
            }
        }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited =new boolean[N][N];
        size = 2;
        res = 0;

        StringTokenizer st;
        for(int i =0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());

                if(arr[i][j]==9){
                    visited[i][j] = true;
                    posx = i;
                    posy = j;
                    arr[i][j]=0;
                }
            }
        }

        bfs(posx,posy);
        System.out.println(res);
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[] dx = {0,1,1,1,0,-1,-1,-1};
    public static int[] dy = {1,1,0,-1,-1,-1,0,1};
    public static int R,C; // 킹 위치
    public static HashSet<Integer> xSet;
    public static HashSet<Integer> ySet;
    public static HashSet<Integer> sumSet;
    public static HashSet<Integer> subSet;

    public static boolean check(int x, int y){
        if(xSet.contains(x)) return true;
        if(ySet.contains(y)) return true;
        if(sumSet.contains(x+y)) return true;
        if(subSet.contains(x-y)) return true;

        return false;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        xSet = new HashSet<>();
        ySet = new HashSet<>();
        sumSet = new HashSet<>();
        subSet = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i =0; i< K ; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xSet.add(x);
            ySet.add(y);
            sumSet.add(x+y);
            subSet.add(x-y);
        }

        String res = "NONE";

        if(check(R,C)){
            res = "CHECKMATE";
            for(int i =0; i< 8; i++){
                int nx = R + dx[i];
                int ny = C + dy[i];

                if(nx < 1|| nx >N || ny <1 || ny >N) continue;
                if(!check(nx,ny)) {
                    res = "CHECK";
                    break;
                }
            }

        }
        else{
            res = "STALEMATE";
            for(int i =0; i< 8; i++){
                int nx = R + dx[i];
                int ny = C + dy[i];

                if(nx < 1|| nx >N || ny <1 || ny >N) continue;
                if(!check(nx,ny)) {
                    res = "NONE";
                    break;
                }
            }
        }

        System.out.println(res);

    }
}


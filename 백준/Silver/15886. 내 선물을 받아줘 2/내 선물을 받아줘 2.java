import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr= new char[N];
        int[] num = new int[N];
        HashSet<Integer> hs = new HashSet<>();

        String str= br.readLine();

        for(int i =0;i<N;i++){
            arr[i] = str.charAt(i);
        }
        for(int i =0;i<N;i++){
            num[i] = -1;
        }

        for(int i=0;i<N;i++){
            boolean[] visited = new boolean[N];
            int nx = i;

            while(true){
                visited[nx] = true;
                num[i] = nx;
                if(arr[nx]=='E'){
                    nx++;
                }
                else nx--;

                if(num[nx]!=-1){
                    num[i] = num[nx];
                    break;
                }
                if(visited[nx]) {
                    break;
                }

            }
        }
        for(int i =0;i<N;i++){
            hs.add(num[i]);
        }

        System.out.println(hs.size());
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int i =0;i<N;i++){
            HashSet<Integer> hs = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                arr[i][j]= n;
                hs.add(n);
            }
            ArrayList<Integer> tmp = new ArrayList<>(hs);
            Collections.sort(tmp);

            for(int j =0;j<M;j++){
                int idx = Collections.binarySearch(tmp, arr[i][j]);
                arr[i][j]=idx;
            }
        }

        int res =0;

        for(int i =0;i<N;i++){
            for(int j = i+1;j<N;j++){
                if(Arrays.equals(arr[i],arr[j])) res ++;
            }
        }

        System.out.println(res);

    }
}

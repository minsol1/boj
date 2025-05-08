import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        ArrayList<Integer> pos = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if( arr[i]==1) pos.add(i);
        }
        if(pos.size()<K){
            System.out.println(-1);
        }
        else{

            int res = Integer.MAX_VALUE;
            for(int l =0;l<pos.size();l++){
                int r = l;
                int cnt=0;
                while(r<pos.size()){
                    cnt++;
                    if(cnt==K){
                        res  =res < pos.get(r)-pos.get(l)+1?res : pos.get(r)-pos.get(l)+1;
                        break;
                    }
                    r++;
                }
            }

            System.out.println(res);
        }


    }
}

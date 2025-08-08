import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int res = 0;
        int l = 0;
        int r = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(C,1);

        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(i<K)
            {
                if(hm.containsKey(arr[i])){
                    hm.put(arr[i], hm.get(arr[i])+1);
                }
                else{
                    hm.put(arr[i],1);
                }
                r++;
            }
        }
        res = res > hm.size() ?res : hm.size();

        while(l < N-1){
            hm.put(arr[l], hm.get(arr[l])-1);
            if(hm.get(arr[l]) == 0) hm.remove(arr[l]);
            l++;
            if(hm.containsKey(arr[r])){
                hm.put(arr[r], hm.get(arr[r])+1);
            }
            else{
                hm.put(arr[r],1);
            }
            r = (r+1)%N;
            res = res > hm.size() ?res : hm.size();
        }

        System.out.println(res);

    }
}

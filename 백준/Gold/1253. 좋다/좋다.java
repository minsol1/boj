import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        int res=0;

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }

        for(int i =0;i<N;i++){
            for(int j =i+1; j<N;j++){
                int sum = arr[i]+arr[j];

                if(arr[i]==0 && arr[j]==0){
                    if(hm.getOrDefault(sum,0)>=3){
                        set.add(sum);
                    }
                    continue;
                }
                if(arr[i]==0 || arr[j]==0){
                    if(hm.getOrDefault(sum,0)>=2){
                        set.add(sum);
                    }
                    continue;
                }
                if(hm.getOrDefault(sum,0)>0){
                    set.add(sum);
                }
            }
        }

        for(int n : arr){
            if(set.contains(n)){
                res++;
            }
        }

        System.out.println(res);
    }
}

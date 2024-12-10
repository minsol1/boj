import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    public static ArrayList<Integer>[] arr;
    public static HashSet<Integer> hs;

    public static boolean file(int k){
        for(ArrayList<Integer> list : arr){
            if(list.size()>=k){
                if(hs.contains(list.get(k-1))){
                    return false;
                }
                hs.add(list.get(k-1));
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N];
        hs = new HashSet<>();
        int res =1;


        StringTokenizer st;
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int num =0;
            arr[i]= new ArrayList<>();
            while (true){
                int n = Integer.parseInt(st.nextToken());
                if(n==-1) break;
                num = num*10 + n;
                arr[i].add(num);
            }
        }

        while(!file(res)){
            res ++;
            hs.clear();
        }


        System.out.println(res);
    }
}

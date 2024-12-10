import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static int N;
    public static ArrayList<Integer> res ;
    public static int max;
    public static ArrayList<Integer> arr;

    public static void cnt(int n, int idx){
        arr.add(n);
        int num =arr.get(idx-1) - arr.get(idx);

        if(num>=0){
            cnt(num, idx+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = 0;

        for(int i =1; i<=N;i++){
            arr = new ArrayList<>();
            arr.add(N);
            cnt(i,1);
            if(max< arr.size()){
                max = arr.size();
                res =arr;
            }
        }

        System.out.println(max);
        for(Integer n : res){
            System.out.print(n+" ");
        }
    }
}

import java.io.*;

public class Main {
    public static int N,res;
    public static boolean[] arr;
    public static boolean[] arr1;
    public static boolean[] arr2;

    public static void greedy(boolean[] arr,int cnt){
        for(int i=0;i<N-1;i++){
            if(arr[i]!=arr2[i]){
                cnt++;

                for(int j =0;j<3;j++){
                    if(i+j >=0 && i+j<N){
                        arr[i+j] = !arr[i+j];
                    }
                }
            }
        }
        for(int i =0;i<N;i++){
            if(arr[i]!=arr2[i]) {
                return;
            }
        }

        res = res<cnt? res:cnt;
    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        res =Integer.MAX_VALUE;
        arr = new boolean[N];
        arr1 = new boolean[N];
        arr2 = new boolean[N];

        String str = br.readLine();
        for(int i =0;i<N;i++){
            arr1[i] = str.charAt(i)=='1';
            arr[i] = str.charAt(i)=='1';
        }

        str = br.readLine();
        for(int i =0;i<N;i++){
            arr2[i] = str.charAt(i)=='1';
        }
        greedy(arr1,0);
        arr[0] = !arr[0];
        arr[1] = !arr[1];
        greedy(arr,1);

        if(res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);

    }
}

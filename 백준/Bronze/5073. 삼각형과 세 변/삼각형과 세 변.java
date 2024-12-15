import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a;
        int b;
        int c;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        while(a!=0 && b!=0 &&c!=0){

            int[]arr = new int[3];
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
            Arrays.sort(arr);
            int res = arr[2] -(arr[0]+arr[1]);

            if(res >=0){
                System.out.println("Invalid");
            }
            else{
                int cnt=0;
                if(arr[0]==arr[1]) cnt++;
                if(arr[1]== arr[2]) cnt++;
                if(arr[2]== arr[0]) cnt++;

                if(cnt==0){
                    System.out.println("Scalene");
                }
                else if(cnt ==1){
                    System.out.println("Isosceles");
                }
                else{
                    System.out.println("Equilateral");
                }
            }

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}

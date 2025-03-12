import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int n =0;

        for(int i =0; i<len;i++){
            char c = str.charAt(i);
            if(c == 'a'){
                n++;
            }
        }

        int l =0;
        int r = n-1;
        int bCnt =0;
        for(int i = 0; i<=r;i++){
            char c = str.charAt(i);
            if(c == 'b'){
                bCnt++;
            }
        }
        int res = bCnt;
        if(res ==0){
            System.out.print(res);
        }
        else{
            while(true){
                if('b' == str.charAt(l)){
                    bCnt--;
                }
                l = (l+1)%len;
                r = (r+1)%len;
                if('b' == str.charAt(r)){
                    bCnt++;
                }

                res = res < bCnt? res : bCnt;
                if(l == 0) break;
            }

            System.out.print(res);

        }

    }
}

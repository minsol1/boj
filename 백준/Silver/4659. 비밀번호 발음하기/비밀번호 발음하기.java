import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if( "end".equals(str)) break;
            int m = 0;
            int j =0;
            char pre=' ';
            boolean flag=true;
            boolean aeiou = false;

            for(int i =0;i<str.length();i++){
                char c = str.charAt(i);
                if(c=='i'|| c=='e'||c=='a'|| c=='o'|c=='u'){
                    aeiou =true;
                    j=0;
                    m++;
                }
                else {
                    m=0;
                    j++;
                }
                if(m>=3|| j>=3) {
                    flag = false;
                    break;
                }
                if(pre == c && c !='o' && c!='e'){
                    flag = false;
                    break;
                }else{
                    pre = c;
                }

            }
            if(aeiou && flag){
                sb.append('<').append(str).append("> is acceptable.\n");
            }
            else{
                sb.append('<').append(str).append("> is not acceptable.\n");
            }


        }
        System.out.print(sb);
    }
}

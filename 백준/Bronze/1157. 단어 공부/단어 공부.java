import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = new int[26];

        for(int i =0;i<str.length();i++){
            char c = str.charAt(i);

            if(c>='a'&& 'z'>=c){
                arr[c-'a']++;
            }
            else{
                arr[c-'A']++;
            }
        }
        char res='?';
        int max =0;
        for(int i=0;i<26;i++){
            if(arr[i]==max){
                res = '?';
            }
            else if(arr[i]>max){
                max = arr[i];
                res = (char)('A'+i);
            }
        }
        System.out.print(res);

    }

}

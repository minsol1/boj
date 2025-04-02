import java.util.*;
import java.io.*;

public class Main {

    public static void printStr(String[] str){
        for(String s : str){
            System.out.print(s+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> sh = new HashSet<>();

        for(int i =0;i<N;i++){
            String[] arr = br.readLine().split(" ");
            boolean f = false;

            for(int j =0; j< arr.length;j++){
                if(!sh.contains(arr[j].charAt(0))){

                    sh.add(Character.toUpperCase(arr[j].charAt(0)));
                    sh.add(Character.toLowerCase(arr[j].charAt(0)));

                    StringBuilder sb = new StringBuilder(arr[j]);
                    sb.insert(0,'[');
                    sb.insert(2,']');

                    arr[j] = sb.toString();
                    f = true;
                    break;
                }
            }
            if(!f){
                for(int j =0; j< arr.length && !f;j++){
                    for(int k = 0; k<arr[j].length();k++){
                        if(!sh.contains(arr[j].charAt(k))){
                            sh.add(Character.toUpperCase(arr[j].charAt(k)));
                            sh.add(Character.toLowerCase(arr[j].charAt(k)));

                            StringBuilder sb = new StringBuilder(arr[j]);
                            sb.insert(k,'[');
                            sb.insert(k+2,']');

                            arr[j] = sb.toString();
                            f = true;
                            break;
                        }
                    }
                }
            }
            printStr(arr);
        }
    }
}

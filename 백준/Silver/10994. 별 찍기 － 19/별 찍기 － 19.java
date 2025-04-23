import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[(n-1)*4+1][(n-1)*4+1];

        for(int k =0; k<n*2-1 ; k++){

            for(int i =k; i<(n-1)*4+1-k ; i++){
                for(int j =k; j<(n-1)*4+1-k;j++){
                    if(k%2 == 0){
                        arr[i][j] = '*';
                    }
                    else{
                        arr[i][j] = ' ';
                    }
                }
            }
        }

        for(int i =0;i<(n-1)*4+1 ; i++){
            for(int j = 0; j<(n-1)*4+1 ; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }

    }
}

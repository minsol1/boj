import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 9;
        int[] arr = new int[N];

        for(int i =0;i<N;i++){
            arr[i]= Integer.parseInt(br.readLine());
        }

        for(int a=0;a<N;a++){
            for(int b=a+1;b<N;b++){
                for(int c=b+1;c<N;c++){
                    for(int d=c+1;d<N;d++){
                        for(int e=d+1;e<N;e++){
                            for(int f=e+1;f<N;f++){
                                for(int g=f+1;g<N;g++){
                                    if(arr[a]+arr[b]+arr[c]+arr[d]+arr[e]+arr[f]+arr[g]==100){
                                        System.out.println(arr[a]);
                                        System.out.println(arr[b]);
                                        System.out.println(arr[c]);
                                        System.out.println(arr[d]);
                                        System.out.println(arr[e]);
                                        System.out.println(arr[f]);
                                        System.out.println(arr[g]);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

}

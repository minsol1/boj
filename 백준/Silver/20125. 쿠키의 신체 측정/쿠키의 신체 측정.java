import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        int x=-1;
        int y =-1;
        int[] res = new int[5];

        for(int i =0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = str.charAt(j);
            }
        }

        // 심장 찾
        for(int i =1;i<N-1;i++){
            for(int j=1;j<N-1;j++){
                if(arr[i-1][j]=='*' && arr[i+1][j]=='*' && arr[i][j-1]=='*' &&arr[i][j+1]=='*'){
                    x = i;
                    y = j;
                }
            }
        }

        //왼 팔 길이
        for(int i =0;i<y;i++){
            if(arr[x][i]=='*') res[0]++;
        }
        //오른 팔 길이
        for(int i =y+1;i<N;i++){
            if(arr[x][i]=='*') res[1]++;
        }

        // 허리 길이
        for(int i =x+1;i<N;i++){
            if(arr[i][y]=='*') res[2]++;
        }
        // 왼 다리
        for(int i =x+1;i<N;i++){
            if(arr[i][y-1]=='*') res[3]++;
        }
        // 오른 다리
        for(int i =x+1;i<N;i++){
            if(arr[i][y+1]=='*') res[4]++;
        }
        x++;
        y++;
        System.out.println(x+" "+y);
        System.out.println(res[0]+" "+res[1]+" "+res[2]+" "+res[3]+" "+res[4]);

    }
}

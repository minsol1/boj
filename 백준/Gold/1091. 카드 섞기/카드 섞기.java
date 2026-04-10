

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N]; // i 번째 카드를 받을 플레이어
        int[] S = new int[N]; // 카드 순서, 초기
        int[] card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i<N ; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N ; i++){
            S[i] = Integer.parseInt(st.nextToken());
            card[i] =S[i];
        }

        int cnt=0;
        boolean f= false;
        while(true){
            f= false;
            for(int i = 0; i< N; i++){
                for(int j = 0; j < N; j++){
                    if(S[j] == card[i]){
                        if (P[j] != i%3){
                            f = true;
                            break;
                        }
                    }
                }
            }
            if(!f){
                System.out.println(cnt);
                return;
            }

            f = false;
            int[] tcnt = new int[N];
            int h=0;
            for(int i =0; i< N; i++){
                tcnt[S[i]] = card[i];
            }

            for(int i =0; i< N; i++){
                if(tcnt[i] != S[i]){
                    f=true;
                }
            }
            if(!f){
                System.out.println(-1);
                return;
            }

            card = tcnt;
            cnt++;

        }

    }
}

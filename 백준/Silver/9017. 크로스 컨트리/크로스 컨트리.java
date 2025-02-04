import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T;t++){
            int[] cnt = new int[201];// 팀원 수
            int[] score = new int[201]; // 점수
            int[] five = new int[201]; // 5번째
            int res=0; // 우승팀

            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();

            StringTokenizer st = new StringTokenizer(str);
            for(int i =0;i<N;i++){
                int n = Integer.parseInt(st.nextToken());
                cnt[n]++;
            }

            st = new StringTokenizer(str);
            int S=1;
            int minscore =Integer.MAX_VALUE;
            int min = 1000001;
            int[] cnt2 = new int[201];
            for(int i =0;i<N;i++){
                int n = Integer.parseInt(st.nextToken());
                if(cnt[n]==6){
                    cnt2[n]++;
                    if(cnt2[n]<=4){
                        score[n]+=S;

                    }
                    if(cnt2[n]==4){
                        minscore = minscore<score[n]?minscore:score[n];
                    }
                    if(cnt2[n]==5){
                        five[n] = S;
                    }
                    S++;
                }
            }

            for(int i =1;i<201;i++){
                if(score[i]==minscore){
                    if(five[i]<min){
                        res  = i;
                        min = five[i];
                    }
                }
            }


            System.out.println(res);


        }
    }
}

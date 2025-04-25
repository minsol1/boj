import java.io.*;

public class Main {
    public static int N;

    public static void dfs(char[] fun, int sum,int cnt,int pre){
        if(cnt==N){
            if(sum!=0) return;
            StringBuilder sb = new StringBuilder();

            for(int i =0;i<N-1;i++){
                sb.append(i+1).append(fun[i]);
            }
            sb.append(N);
            System.out.println(sb);
            return;
        }
        fun[cnt-1] = ' ';
        if(pre<0){
            dfs(fun,sum-(pre)+(pre*10-cnt-1), cnt+1,(pre*10-cnt-1));
        }
        else{
            dfs(fun,sum-(pre)+(pre*10+cnt+1), cnt+1,(pre*10+cnt+1));
        }
        fun[cnt-1] = '+';
        dfs(fun,sum+(cnt+1), cnt+1,cnt+1);
        fun[cnt-1] = '-';
        dfs(fun,sum-(cnt+1), cnt+1,-(cnt+1));


    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt (br.readLine());

        for(int t =0;t<T;t++){
            N = Integer.parseInt(br.readLine());

            dfs(new char[N-1],1,1,1);
            System.out.println("");

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] isprime;

    public static void prime(){// 소수면 false 아니면 true
        isprime[2] = false;
        isprime[3] = false;

        for(int i =2; i<1000001; i++){
            if(!isprime[i]){
                for(int j = i*2;j<1000001;j+=i){
                    isprime[j] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        isprime = new boolean[1000001];
        prime();

        while(n!=0){
            for(int i =3;i<=n;i++){
                if(i%2==1){
                    if(!isprime[i]&&!isprime[n-i]){
                        sb.append(n+" = "+i+" + "+(n-i)).append("\n");
                        break;
                    }
                }
                if(i>n/2){
                    sb.append("Goldbach's conjecture is wrong.\n");
                    break;
                }
            }
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);

    }
}

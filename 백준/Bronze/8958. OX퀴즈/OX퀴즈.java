import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i =0;i<N;i++){
            String str = br.readLine();
            int total =0;

            int score =0;

            for(int j =0;j<str.length();j++){
                if(str.charAt(j) == 'O'){
                    score++;
                    total += score;
                }
                else{
                    score=0;
                }
            }
            System.out.println(total);
        }
    }
}

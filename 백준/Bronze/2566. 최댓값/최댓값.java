import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = -1;
        int x = 0;
        int y = 0;

        for (int i = 1; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > max) {
                    max = num;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.print(x + " " + y);

    }

}

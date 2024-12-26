import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs = new HashSet<>();
        for(int i =0; i<10;i++){
            int N = Integer.parseInt(br.readLine());
            hs.add(N%42);
        }
        System.out.println(hs.size());

    }
}

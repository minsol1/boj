import java.util.*;
import java.io.*;

public class Main {

    public static boolean check(String str, char xo) {
        boolean x = false;

        for (int i = 0; i < 3; i++) {
            int xcnt = 0;

            for (int j = 0; j <= 6; j += 3) {
                char c = str.charAt(i + j);
                if (c == xo) xcnt++;
            }
            if (xcnt == 3) x = true;
        }
        for (int i = 0; i < 3; i++) {
            int xcnt = 0;

            for (int j = 0; j < 3; j++) {
                char c = str.charAt(i * 3 + j);
                if (c == xo) xcnt++;
            }
            if (xcnt == 3) x = true;
        }
        int xcnt = 0;
        for (int i = 0; i < 9; i += 4) {
            char c = str.charAt(i);
            if (c == xo) xcnt++;

            if (xcnt == 3) x = true;
        }
        xcnt = 0;
        for (int i = 2; i <= 6; i += 2) {
            char c = str.charAt(i);
            if (c == xo) xcnt++;
            if (xcnt == 3) x = true;
        }

        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();

            if ("end".equals(str)) break;

            int xcnt = 0;
            int ocnt = 0;

            for (int i = 0; i < 9; i++) {
                char c = str.charAt(i);

                if (c == 'X') xcnt++;
                if (c == 'O') ocnt++;
            }

            if (xcnt == ocnt || xcnt - ocnt == 1) {
                boolean isXPossible = check(str, 'X');
                boolean isOPossible = check(str, 'O');

                if (isXPossible && isOPossible) {
                    System.out.println("invalid");
                } else if (isXPossible) {
                    if (xcnt == ocnt) System.out.println("invalid");
                    else System.out.println("valid");
                } else if (isOPossible) {
                    if (xcnt == ocnt) System.out.println("valid");
                    else System.out.println("invalid");
                } else if (xcnt + ocnt == 9) System.out.println("valid");
                else {
                    System.out.println("invalid");
                }
            } else System.out.println("invalid");
        }
    }
}


import java.io.*;
import java.util.*;

public class Main {
    public static int kx, ky, sx,sy;
    public static int[]dx = {0,1,1,1,0,-1,-1,-1};
    public static int[]dy = {1,1,0,-1,-1,1,0,-1};
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = 8;
        String str = st.nextToken();
        ky = str.charAt(0) - 'A';
        kx = str.charAt(1) - '1';
        str = st.nextToken();
        sy = str.charAt(0) - 'A';
        sx = str.charAt(1) - '1';
        M = Integer.parseInt(st.nextToken());


        for(int i = 0; i<M;i++){
            String cmd = br.readLine();
            int nx = kx;
            int ny = ky;
            int nsx = sx;
            int nsy = sy;

            if("R".equals(cmd)){
                ny++;
                nsy++;
            }
            if("L".equals(cmd)){
                ny--;
                nsy--;
            }
            if("B".equals(cmd)){
                nx--;
                nsx--;
            }
            if("T".equals(cmd)){
                nx++;
                nsx++;
            }
            if("RT".equals(cmd)){
                ny++;
                nsy++;
                nx++;
                nsx++;
            }
            if("LT".equals(cmd)){
                ny--;
                nsy--;
                nx++;
                nsx++;
            }
            if("RB".equals(cmd)){
                ny++;
                nsy++;
                nx--;
                nsx--;
            }
            if("LB".equals(cmd)){
                ny--;
                nsy--;
                nx--;
                nsx--;
            }
            if(nx <0 || nx >= N || ny <0 || ny >= N) continue;
            if(nx == sx && ny == sy){
                if(nsx <0 || nsx >= N || nsy <0 || nsy >= N) continue;
                else{
                    kx = nx;
                    ky = ny;
                    sx = nsx;
                    sy = nsy;
                }
                continue;
            }

            kx = nx;
            ky = ny;
        }

        kx++;
        sx++;
        char k = (char)(ky+'A');
        char s = (char)(sy+'A');
        System.out.println(k+ ""+kx);
        System.out.println(s+"" +sx);
    }
}

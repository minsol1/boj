import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        String res="";
        HashMap<String , Integer> hm = new HashMap<>();

        for(int i =0;i<N;i++){
            String str = br.readLine();
            if(hm.containsKey(str)){
                hm.put(str, hm.get(str)+1);
            }
            else{
                hm.put(str,1);
            }

            if(hm.get(str)>max){
                max = hm.get(str);
                res = str;
            }
            else if(hm.get(str) == max && str.compareTo(res)<0){
                res = str;
            }
        }
        System.out.println(res);
    }
}

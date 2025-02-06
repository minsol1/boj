import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int cnt;
    String str;
    int len;

    public Node(String str){
        this.cnt =0;
        this.str = str;
        this.len = str.length();
    }

    @Override
    public int compareTo(Node o) {
        if(o.cnt==this.cnt){
            if(o.len == this.len){
                return this.str.compareTo(o.str);

            }
            return o.len-len;

        }
        else{
            return o.cnt-cnt;
        }
    }
}

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Node> arr = new ArrayList<>();
        HashMap<String,Node> hm = new HashMap<>();

        for(int i =0;i<N;i++){
            String str = br.readLine();
            if(str.length()>=M){
                Node node;
                if(hm.containsKey(str)){
                    node = hm.get(str);
                    node.cnt++;
                }
                else{
                    node = new Node(str);
                    hm.put(str, node);
                    arr.add(node);
                }
            }
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(Node node : arr){
            sb.append(node.str).append('\n');
        }
        System.out.print(sb);
    }
}

import java.util.*;

class Node implements Comparable<Node>{
    String title;
    int time;
    String abc;
    
    public Node(String title, int time, String abc){
        this.title = title;
        this.time = time;
        this.abc = abc;
    }
    
    public int compareTo(Node o){
        return o.time - time;
    }
}
class Solution {
    
    public static ArrayList<Node> arr;
    
    public static int getTime(String start, String end){
        StringTokenizer st = new StringTokenizer(start, ":");
        int sh = Integer.parseInt(st.nextToken());
        int sm = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(end, ":");
        int eh = Integer.parseInt(st.nextToken());
        int em = Integer.parseInt(st.nextToken());
        
        int time = em - sm; 
        if(time <0){
            time += 60;
            eh--;
        }
        time += (eh-sh)*60;
        
        return time;
    }
    
    public static String getSong(int time, String abc){
        StringBuilder sb = new StringBuilder();
            int idx = 0;
            int n = abc.length();
            while(time>0){
                char c = abc.charAt(idx);
                sb.append(c);
                if(c!='#') time--;
                idx++;
                idx%=n;
            }
        return sb.toString();
    }
    
    public static String change(String str){
        return str.replace("C#" , "c")
                .replace("D#" , "d")
            .replace("F#" , "f")
            .replace("G#" , "g")
            .replace("B#" , "b")
            .replace("E#" , "e")
            .replace("A#" , "a");
    }
    
    public static boolean check(String song, String neoSong){
        
        return song.contains(neoSong);
    }
    
    public String solution(String m, String[] musicinfos) {
        String res = "(None)";
        int N = musicinfos.length;
        arr = new ArrayList<>();
        m = change(m);
        
        for(int i =0; i< N ; i++){
            StringTokenizer st = new StringTokenizer(musicinfos[i],",");
            String start = st.nextToken();
            String end = st.nextToken();
            String title =  st.nextToken();
            String abc = change( st.nextToken());
            
            int time = getTime(start, end);
            String song = getSong(time, abc);
            arr.add(new Node(title, time, song));
            System.out.println(song);
            
        }
        
        Collections.sort(arr);
        for(Node node : arr){
            if(check(node.abc, m)) {
                res = node.title;
                break;
            }
        }
        
        return res;
    }
}
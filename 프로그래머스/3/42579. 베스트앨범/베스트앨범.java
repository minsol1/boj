import java.util.*;
import java.io.*;

class Genre implements Comparable<Genre>{
    String str;
    ArrayList<Song> songs;
    int cnt;
    
    public Genre (String str, ArrayList<Song> songs, int cnt){
        this.str= str;
        this.songs = songs;
        this.cnt = cnt;
    }
    
    public int compareTo(Genre o ){
        return o.cnt - cnt;
    }
}

class Song implements Comparable<Song>{
    int idx;
    int cnt;
    
    public Song (int idx , int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
    
    public int compareTo(Song o){
        return o.cnt - cnt;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> hm = new HashMap<>();
        ArrayList<Genre> arr = new ArrayList<>();
        
        for(int i =0; i< genres.length; i++){
            String str = genres[i];
            int cnt = plays[i];
            Song song = new Song(i, plays[i]);
            
            if(hm.containsKey(str)){
                Genre g = hm.get(str);
                g.songs.add(song);
                g.cnt+= cnt;
            }
            else{
                ArrayList<Song> songs = new ArrayList<>();
                songs.add(song);
                Genre g = new Genre(str, songs, cnt );
                arr.add(g);
                hm.put(str,g);
            }
        }
        // System.out.println(hm.size()+" "+ arr.size());
        
        Collections.sort(arr);
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i =0; i< arr.size();i++){
            Genre genre = arr.get(i);
            Collections.sort(genre.songs);
            
            answer.add(genre.songs.get(0).idx);
            if(genre.songs.size() >1) answer.add(genre.songs.get(1).idx);
            
        }
        int[] res = new int[answer.size()];
        for(int i =0; i< answer.size(); i++){
            res[i] = answer.get(i);
        }
        
        return res;
    }
}
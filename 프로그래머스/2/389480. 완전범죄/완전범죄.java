import java.util.*;
class Node implements Comparable<Node>{
    int A;
    int B;
    
    public Node (int A, int B){
        this.A = A;
        this.B = B;
    }
    
    public int compareTo(Node o){
        if(this.A == o.A){
            return o.B - this.B;
        }
        else return o.A - this.A;
    }
    
}

class Solution {
    
    public static int N, M;
    public static Node[] arr;
    public static int res;
    
    public static void dfs(int A,int B,int idx){
        if(A >= N || B >= M) return;
        if(res <= A) return;
        
        if(idx == arr.length) {
            res = res < A ? res : A;
            return;
        }
        
        dfs(A, B + arr[idx].B , idx + 1);
        dfs(A + arr[idx].A , B , idx + 1);
    }
    public int solution(int[][] info, int n, int m) {
        res = Integer.MAX_VALUE;
        arr = new Node[info.length];
        N = n;
        M = m;
        
        for(int i = 0; i< info.length ; i++){
            arr[i] = new Node(info[i][0],info[i][1]);
        }
        Arrays.sort(arr);
        
        dfs(0,0,0);
        
        if(res == Integer.MAX_VALUE) res = -1;
        return res;
    }
}

// import java.util.*;

// class Solution {
    
//     public static int N, M;
//     public static int[][] arr;
//     public static int res;
    
//     public static void dfs(int A,int B,int idx){
//         if(A >= N || B >= M) return;
//         if(res <= A) return;
        
//         if(idx == arr.length) {
//             res = res < A ? res : A;
//             return;
//         }
        
//         dfs(A, B + arr[idx][1] , idx + 1);
//         dfs(A + arr[idx][0], B , idx + 1);
//     }
//     public int solution(int[][] info, int n, int m) {
//         res = Integer.MAX_VALUE;
//         arr = info;
//         N = n;
//         M = m;
        
//         Arrays.sort(arr, (a,b) -> b[1] - a[1]);
        
//         dfs(0,0,0);
        
//         if(res == Integer.MAX_VALUE) res = -1;
//         return res;
//     }
// }


import java.util.*;

class Node implements Comparable<Node>{
    int a;
    int b;
    
    public Node(int a , int b){
        this.a = a;
        this.b = b;
    }
    
    public int compareTo(Node o){
        if(a == o.a){
            return o.b -b;
        }
        return o.a - a;
    }
}
class Solution {
    
    public static int res;
    public static int N,M;
    public static Node[] arr;
    
    public static void dfs(int idx, int A, int B){
        if(A >= N || B >= M) return;
        if(A >= res) return;
        
        if(idx == arr.length){
            res = Math.min(A, res);
            return;
        }
        
        dfs(idx+1, A,B+ arr[idx].b);
        dfs(idx+1, A+arr[idx].a,B);
        
    }
    
    public int solution(int[][] info, int n, int m) {
        res = Integer.MAX_VALUE;
        arr = new Node[info.length];
        N = n;
        M = m;
        
        for(int i =0; i< info.length; i++){
            arr[i] = new Node(info[i][0],info[i][1]);
        }
        
        Arrays.sort(arr);
        
        dfs(0,0,0);
        
        if( res == Integer.MAX_VALUE) res = -1;
        return res;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int res = 0;
	static int N; 
	
	static void dfs(List<Integer> list,int sum) {
		if(list.size()==2) {
			res = res > sum?res : sum;
			return;
		}
		
		for(int i=1;i<list.size()-1;i++) {
			int temp = list.get(i);
			int s = list.get(i-1)*list.get(i+1);
			list.remove(i);
			dfs(list,sum+s);
			list.add(i,temp);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		List<Integer> arr = new LinkedList<>();
		
		st= new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(arr,0);
		System.out.println(res);

	}

}

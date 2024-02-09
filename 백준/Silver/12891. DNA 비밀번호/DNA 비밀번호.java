import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int S;
	static int P;
	static String str;
	static int res;
	static int[] arr;
	static int[] cnt;
	
	static void check() {
		for(int i=0;i<4;i++) {
			if(arr[i]>cnt[i]) {
				return;
			}
		}
		res++;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		
		arr = new int[4];
		cnt = new int[4];
		res =0;
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<4;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<P;i++) {
			switch(str.charAt(i)) {
			case 'A':
				cnt[0]++;
				break;
			
			case 'C':
				cnt[1]++;
				break;
				
			case 'G':
				cnt[2]++;
				break;
				
			case 'T':
				cnt[3]++;
				break;
			}
		}
		
		check();
		
		for(int i=0;i<S-P;i++) {
			switch(str.charAt(i)) {
			case 'A':
				cnt[0]--;
				break;
				
			case 'C':
				cnt[1]--;
				break;
				
			case 'G':
				cnt[2]--;
				break;
				
			case 'T':
				cnt[3]--;
				break;
			}
			switch(str.charAt(i+P)) {
			case 'A':
				cnt[0]++;
				break;
				
			case 'C':
				cnt[1]++;
				break;
				
			case 'G':
				cnt[2]++;
				break;
				
			case 'T':
				cnt[3]++;
				break;
			}
			
			check();
		}
		
		
		
		System.out.println(res);
	}

}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static long S,E ;

    static HashMap<Long, Long> f;
	
	public static long F(long x) {
		if (f.containsKey(x))
            return f.get(x);
        if (x < 10)
            return f.get(x);
		else {
			long v = V(x);
			long ff = F((long)x-1-x%v);
			long g = (x/v)*(x%v+1)+F(x%v);
			long num = ff+g;
			f.put(x, num);
			return num;
		}
	}

	public static long V(long x) {
		long v = 1;
        while (x >= 10) {
            v = v * 10;
            x = x / 10;
        }
        return v;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("src/sample_input.txt"));

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());

		f = new HashMap<Long, Long>();
		long sum = 0;
		for (long i = 0; i < 10; i++) {
			sum += i;
			f.put(i, sum);
		}
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			S = Long.parseLong(st.nextToken());
			E = Long.parseLong(st.nextToken());

			if(S>0) {
				System.out.print("#"+test_case+" "+(F(E)-F(S-1)));
				System.out.println("");
				
			}else {
				System.out.print("#"+test_case+" "+(F(E)-F(S)));
				System.out.println("");
				
				
			}
//			(int)(Math.log10(E)+1);
			
		}
		
	}

}

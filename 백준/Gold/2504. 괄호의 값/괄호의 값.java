import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int res = 0;
        int tem = 1;
        char pre=' ';

        for(int i = 0; i<str.length();i++){
            char c = str.charAt(i);
            if(c == '('){
                tem*=2;
                stack.push(c);
            }
            else if(c == '['){
                tem*=3;
                stack.push(c);
            }
            else if(c == ')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    if(pre == '('){
                        res+=tem;
                    }
                    stack.pop();
                    tem/=2;
                }
                else{
                    res = 0;
                    break;
                }

            }
            else if(c == ']'){
                if(!stack.isEmpty() && stack.peek()=='['){
                    if(pre == '['){
                        res+=tem;
                    }
                    stack.pop();
                    tem/=3;
                }
                else{
                    res = 0;
                    break;
                }
            }
            else{
                res = 0;
                break;
            }
            pre =c;
        }

        if(!stack.isEmpty()){
            res = 0;
        }
        System.out.print(res);

    }
}

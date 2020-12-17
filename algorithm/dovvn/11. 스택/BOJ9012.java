import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++){
            Stack<Character> stack = new Stack<>();
            boolean isVpn = true;
            char[] chArr = br.readLine().toCharArray();

            for(int i=0; i<chArr.length; i++){
                int x = chArr[i];

                if(x == '('){
                    stack.push('(');
                }else{
                    if(stack.empty()){
                        isVpn = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }//End input

            if(isVpn && stack.empty()) sb.append("YES\n");
            else sb.append("NO\n");
        }//End tc
        bw.write(sb+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
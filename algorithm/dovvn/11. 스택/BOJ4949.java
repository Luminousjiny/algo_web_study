import java.io.*;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            char[] chArr = br.readLine().toCharArray();
            if(chArr[0] == '.') break;

            Stack<Character> opens = new Stack<>();
            boolean isBalance = true;

            for(int i=0; i<chArr.length; i++){

                switch(chArr[i]){
                    case '(':
                    case '[':
                        opens.add(chArr[i]);
                        continue;
                    case ')':
                        if(opens.empty() || opens.peek()!='('){
                            isBalance = false;
                            break;
                        }else opens.pop();
                        continue;
                    case ']':
                        if(opens.empty() || opens.peek()!='['){
                            isBalance = false;
                            break;
                        }else opens.pop();
                        continue;
                    default:
                        continue;
                }
            }//End 균형 판단
            if(opens.empty() && isBalance) sb.append("yes\n");
            else sb.append("no\n");
        }//End input

        bw.write(sb+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
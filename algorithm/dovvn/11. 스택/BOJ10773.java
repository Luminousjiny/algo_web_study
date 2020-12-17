import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static int K;
    static int Ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(stack.empty()) continue;
                stack.pop();
            }else{
                stack.push(num);
            }
        }//End input

        while(!stack.empty()){
            Ans += stack.pop();
        }

        bw.write(Ans+"");
        bw.close();
        br.close();
    }
}
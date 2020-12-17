import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static int N; //명령의 수
    static String order;
    static int x;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for(int i=0; i<N; i++){
            order = br.readLine();

            if(order.contains("push")){
                String[] orders = order.split(" ");
                stack.push(Integer.parseInt(orders[1]));
            }else if(order.equals("pop")){
                if(stack.empty()) sb.append(-1+"\n");
                else{
                    sb.append(stack.peek()+"\n");
                    stack.pop();
                }
            }else if(order.equals("size")){
                sb.append(stack.size()+"\n");
            }else if(order.equals("empty")){
                if(stack.empty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            }else{
                if(stack.empty()) sb.append(-1+"\n");
                else sb.append(stack.peek()+"\n");
            }
        }//End input

        bw.write(sb.toString()+"");
        bw.close();
        br.close();
    }
}
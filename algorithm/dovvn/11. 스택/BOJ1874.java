import java.io.*;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine()); //End input
            max = Math.max(max, arr[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int num=1;
        int i = 0; //arr인덱스

        while(true){

            while(!stack.empty() && stack.peek()==arr[i]){
                stack.pop();
                sb.append("-\n");
                i++;
            }
            if(i>=N) break;
            if(num>N){ //수열을 만들 수 없는 경우
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
            stack.add(num++);
            sb.append("+\n");
        }//End 연산

        bw.write(sb+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
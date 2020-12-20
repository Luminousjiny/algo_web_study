import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> queue = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(input.contains("push")) queue.add(Integer.parseInt(input.substring(5)));
            else{
                switch(input){
                    case "front":
                        if(queue.isEmpty()) sb.append(-1+"\n");
                        else sb.append(queue.peek()+"\n");
                        break;
                    case "back":
                        if(queue.isEmpty()) sb.append(-1+"\n");
                        else sb.append(queue.peekLast()+"\n");
                        break;
                    case "size":
                        sb.append(queue.size()+"\n");
                        break;
                    case "empty":
                        if(queue.isEmpty()) sb.append(1+"\n");
                        else sb.append(0+"\n");
                        break;
                    case "pop":
                        if(queue.isEmpty()) sb.append(-1+"\n");
                        else sb.append(queue.poll()+"\n");
                    default:
                        break;
                }
            }
        }
        bw.write(sb+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
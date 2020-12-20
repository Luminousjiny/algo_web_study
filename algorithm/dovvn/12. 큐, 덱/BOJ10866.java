import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(input.contains("push_back")) deque.addLast(Integer.parseInt(input.substring(10)));
            else if(input.contains("push_front")) deque.addFirst(Integer.parseInt(input.substring(11)));
            else{
                switch(input){
                    case "pop_front":
                        if(deque.isEmpty()) sb.append(-1+"\n");
                        else sb.append(deque.removeFirst()+"\n");
                        break;
                    case "pop_back":
                        if(deque.isEmpty()) sb.append(-1+"\n");
                        else sb.append(deque.removeLast()+"\n");
                        break;
                    case "size":
                        sb.append(deque.size()+"\n");
                        break;
                    case "empty":
                        if(deque.isEmpty()) sb.append(1+"\n");
                        else sb.append(0+"\n");
                        break;
                    case "front":
                        if(deque.isEmpty()) sb.append(-1+"\n");
                        else sb.append(deque.getFirst()+"\n");
                        break;
                    case "back":
                        if(deque.isEmpty()) sb.append(-1+"\n");
                        else sb.append(deque.getLast()+"\n");
                        break;
                    default:
                        break;
                }
            }
        }//End

        System.out.println(sb+"");
    }
}
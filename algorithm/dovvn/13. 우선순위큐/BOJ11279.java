import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            x = Integer.parseInt(br.readLine());
            if(x==0){ //우선순위 가장 큰 값 출력
                if(queue.isEmpty()) sb.append(0+"\n");
                else sb.append(queue.poll()+"\n");
                continue;
            }
            queue.add(x);
        }

        System.out.println(sb+"");
    }
}
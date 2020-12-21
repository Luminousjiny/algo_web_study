package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 절대 힙
public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> ppq = new PriorityQueue<>(); // 양수 1, 2, 3 ....
        PriorityQueue<Integer> mpq = new PriorityQueue<>(Collections.reverseOrder()); // 음수 -1, -2, -3 ...
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(ppq.isEmpty() && mpq.isEmpty()){
                    sb.append(0).append("\n");
                }else if(ppq.isEmpty()){
                    sb.append(mpq.poll()).append("\n");
                }else if(mpq.isEmpty()){
                    sb.append(ppq.poll()).append("\n");
                }else {
                    int ppeek = Math.abs(ppq.peek());
                    int mpeek = Math.abs(mpq.peek());
                    if(ppeek > mpeek){
                        sb.append(mpq.poll()).append("\n");
                    }else if( ppeek < mpeek){
                        sb.append(ppq.poll()).append("\n");
                    }else{
                        sb.append(mpq.poll()).append("\n");
                    }
                }
            }else{
                if(x>0) ppq.add(x);
                else mpq.add(x);
            }
        }
        System.out.println(sb.toString());
    }
}

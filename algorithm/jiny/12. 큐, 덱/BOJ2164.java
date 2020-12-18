package day1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println(N);
        }else{
            Queue<Integer> qu = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                qu.add(i);
            }

            while (true){
                qu.poll();
                if(qu.size() == 1) {
                    System.out.println(qu.peek());
                    break;
                }
                int q = qu.poll();
                qu.add(q);
            }
        }

    }
}

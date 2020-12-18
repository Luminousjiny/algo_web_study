package day1218;
import java.io.*;
import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }
        while(queue.size() != 1){
            queue.poll();
            int a = queue.poll();
            queue.add(a);
        }
        bw.write(queue.poll() + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
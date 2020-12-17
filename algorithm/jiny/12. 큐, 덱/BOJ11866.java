package day1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//요세푸스 문제 0
public class BOJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            qu.add(i);
        }
        int cnt = 0, nb=0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!qu.isEmpty()){
            int num = qu.poll();
            nb++;
            if(nb%K == 0) {
                sb.append(num); // K의 배수
                cnt ++;
                if(cnt != N) sb.append(", ");
            }
            else qu.add(num); // K의 배수가 아니면 다시 넣고
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}

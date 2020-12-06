package day1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11047 {
    static StringTokenizer st;
    static ArrayList<Integer> money; // 들어오는 종류 배열
    static int N, K, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        money = new ArrayList<>(); // 들어오는 돈이 배수 -> 그리디 접근 가능
        for (int i = 0; i < N; i++) {
            int m = Integer.parseInt(br.readLine());
            if( m <= K) money.add(m);
        }

        for (int i = money.size()-1; i >= 0; i--) {
            int res = K/money.get(i);
            count += res;
            K = K - (money.get(i)*res);
            if(K == 0) break;
        }
        System.out.println(count);
    }
}

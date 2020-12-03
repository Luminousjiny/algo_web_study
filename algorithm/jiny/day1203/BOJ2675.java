package day1203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken()); // 반복횟수
            String S = st.nextToken(); // 문자열
            for (int i = 0; i < S.length(); i++) {
                for (int j = 0; j < R; j++) {
                    System.out.print(S.charAt(i));
                }
            }

        }
        System.out.println();

    }
}

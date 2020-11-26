package day1126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11022 {
    /**
     * A + B 출력
     */
    static int TC, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(tc).append(": ").append(A).append(" + ").append(B).append(" = ").append(A + B).append("\n");
        }
        System.out.println(sb.toString());
    }
}

package day1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {
    static int TC, R;
    static String S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            S = st.nextToken();

            int size = S.length();

            for(int i = 0; i < size; i++){
                char curr = S.charAt(i);
                for(int j = 0; j < R; j++){
                    sb.append(curr);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

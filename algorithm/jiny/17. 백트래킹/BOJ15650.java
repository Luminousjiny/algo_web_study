package BOJ0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// N과 M 2
public class BOJ15650 {
    static StringTokenizer st;
    static int N, M;
    static int number[];
    static boolean[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[M];
        select = new boolean[N+1];

        c(0, 1);
    }
    static void c(int cnt, int cur) {
        if(cnt == M) {
            for(int i=0; i<number.length; i++) {
                System.out.print(number[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=cur; i<=N; i++) {
            number[cnt] = i;
            c(cnt+1, i+1);
        }
    }
}

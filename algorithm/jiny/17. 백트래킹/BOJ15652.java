package BOJ0107;

import java.io.*;
import java.util.StringTokenizer;
// N과 M 4
public class BOJ15652 {
    static StringTokenizer st;
    static BufferedWriter bw;
    static int N, M;
    static int []number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = new int[M];
        c2(0, 1);
        bw.flush();
        bw.close();

    }
    static void c2(int cnt, int cur) throws IOException {
        if(cnt==M) {
            for(int i=0; i<number.length; i++) {
                bw.write(number[i]+" ");
            }
            bw.newLine();
            return;
        }
        for(int i=cur; i<=N; i++) {
            number[cnt] =i;
            c2(cnt+1, i);
        }
    }
}

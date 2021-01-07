package BOJ0107;

import java.io.*;
import java.util.StringTokenizer;
// N과 M 3
public class BOJ15651 {
    static StringTokenizer st;
    static int N,M;
    static int[] number;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[M];
        p2(0);
        bw.flush();
        bw.close();
    }
    static void p2(int cnt) throws IOException {
        if(cnt == M) {
            for(int i=0; i<number.length; i++) {
                bw.write(number[i]+" ");
            }
            bw.newLine();
            return;
        }
        for(int i=1; i<=N; i++) {
            number[cnt] = i;
            p2(cnt+1);
        }
    }
}

package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
    static int K, N, maxLength;
    static int[] lengths;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        maxLength = 0;
        ans = 0;

        lengths = new int[K];
        for (int i = 0; i < K; ++i) {
            lengths[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, lengths[i]);
        }

        findMaxLength(1, maxLength);

        System.out.println(ans);
    }

    static void findMaxLength(long start, long end) {
        if (start > end) {
            return;
        }

        long cnt = 0; // int 형으로 표현 불가능
        long mid = (start + end) / 2; // int 형으로 표현 불가능

        for (int length : lengths) {
            cnt += (length / mid);
        }

        if (cnt < N) {
            findMaxLength(start, mid - 1);
        } else {
            ans = Math.max(ans, mid);
            findMaxLength(mid + 1, end);
        }
    }
}

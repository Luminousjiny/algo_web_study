package day1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10818 {
    /**
     * N개의 정수가 주어질 때 최솟값과 최대값 구하기
     * 1 <= N <= 1,000,000
     */
    static int N, minNum, maxNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        minNum = 1000001;
        maxNum = -1000001;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            int curr = Integer.parseInt(st.nextToken());
            minNum = Math.min(minNum, curr);
            maxNum = Math.max(maxNum, curr);
        }

        System.out.println(minNum + " " + maxNum);
    }
}

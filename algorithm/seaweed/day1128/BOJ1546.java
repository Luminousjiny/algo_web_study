package day1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1546 {
    /**
     * 원 점수 총 합을 구하면서 최대값 찾기
     * 새로운 점수 총 합 = (원점수 총 합) / M * 100
     */
    static int N, ogSum, ogMax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ogMax = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            int curr = Integer.parseInt(st.nextToken());
            ogSum += curr;
            ogMax = Math.max(ogMax, curr);
        }
        System.out.println((double)ogSum / (ogMax * N) * 100);
    }
}

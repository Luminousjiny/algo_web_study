package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 수정렬하기
// N(1 ≤ N ≤ 1,000)
public class BOJ2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        for (int i = 0; i < N; i++) {
            System.out.println(num[i]);
        }
    }
}

package day1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
    static int N, total;
    static StringTokenizer st;
    static int[] time;
    static int[] sumTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        time = new int[N];
        sumTime = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);// 오름차순 정렬

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += time[j];
            }
            sumTime[i] = sum;
        }

        for (int i = 0; i < N; i++) {
            total += sumTime[i];
        }
        System.out.println(total);
    }

}

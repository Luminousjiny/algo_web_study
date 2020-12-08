package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// 통계학
//  N(1 ≤ N ≤ 500,000)
// -4000 <= n <= 4000
public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 홀수
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        //산술평균
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += num[i];
        }
        long avg = Math.round(sum/(double)N);
        System.out.println(avg);
        // 중앙값
        Arrays.sort(num);
        System.out.println(num[N/2]);
        // 최빈값
        int max = 0;
        int[] count = new int[8001];
        for (int i = 0; i < N; i++) {
            count[num[i]+4000] ++;
        }
        for (int i = 0; i < 8001; i++) {
            max = Math.max(max, count[i]);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if(max == count[i]){
                arr.add(i-4000);
            }
        }
        Collections.sort(arr);
        if(arr.size() == 1) System.out.println(arr.get(0));
        else System.out.println(arr.get(1));
        // 범위
        System.out.println(num[N-1]-num[0]);
    }
}

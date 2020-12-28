package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2108 {
    /**
     * 산술평균
     * 중앙값
     * 최빈값
     * 범위
     */
    static int N, sum, maxNum, minNum, median, mode, range, mean;
    static int[] count, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = new int[8001]; // -4000 ~ 4000
        arr = new int[N];
        maxNum = Integer.MIN_VALUE;
        minNum = Integer.MAX_VALUE;
        for(int i = 0; i < N; ++i){
            int curr = Integer.parseInt(br.readLine());
            arr[i] = curr;
            sum += curr; // 합
            maxNum = Math.max(maxNum, curr); // 최대값
            minNum = Math.min(minNum, curr); // 최소값
            count[curr + 4000]++;
        }
        Arrays.sort(arr);
        median = arr[N / 2]; // 중앙값
        mean = (int)Math.round((double)sum / N); // 평균
        range = maxNum - minNum; // 범위

        // 최빈값 구하기
        int modeCnt = 0;
        for(int i = 0; i <= 8000; ++i){
            if(count[i] > modeCnt){
                modeCnt = count[i];
                mode = i;
            }
        }
        for(int i = mode + 1; i <= 8000; ++i){
            if(modeCnt == count[i]){
                mode = i;
                break;
            }
        }
        mode -= 4000;

        // 결과 출력
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}

package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10989 {
    static int N;
    static int[] count; // 카운트 배열
    static final int MAX_NUM = 10000; // 숫자 범위
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        count = new int[MAX_NUM + 1]; // 카운트 배열
        for(int i = 0; i < N; ++i){
            count[Integer.parseInt(br.readLine())]++;
        }
        for(int i = 1; i <= MAX_NUM; ++i){
            for(int j = 0; j < count[i]; ++j){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

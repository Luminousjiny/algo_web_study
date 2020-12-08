package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 수 정렬하기 3
//  N(1 ≤ N ≤ 10,000,000)
// 10,000보다 작거나 같은 자연수
public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count[] = new int[10001];
        for (int i = 1; i <= N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if(count[i] > 0){
                for (int j = 1; j <= count[i]; j++) {
                    sb.append(i).append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
}

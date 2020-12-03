package day1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4344 {

    static int TC, N;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            scores = new int[N];

            int curSum = 0;
            for(int i = 0; i < N; i++){
                scores[i] = Integer.parseInt(st.nextToken());
                curSum += scores[i];
            }
            int avg = curSum / N;
            int cnt = 0; // 평균 넘는 학생 수
            for(int score : scores){
                if(score > avg)
                    cnt++;
            }
            sb.append(String.format("%.3f", (double)cnt / N * 100)).append("%\n");
        }
        System.out.println(sb.toString());
    }
}

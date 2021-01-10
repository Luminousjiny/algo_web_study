package day0110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    /**
     * N명, 짝수
     * N/2명으로 이루어진 스타트팀, 링크 팀
     * Sij = i번 사람과 j번 사람이 같은 팀이 되었을 때 팀에 더해지는 능력치
     * 
     * 스타트팀과 링크팀 능력치 차이 최소화
     * 4 <= N <= 20
     * 1 <= Sij <= 100
     */
    static int N, ans;
    static boolean[] selected;
    static int[][] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        score = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝
        selected = new boolean[N];
        ans = Integer.MAX_VALUE;
        comb(0, 0);
        System.out.println(ans);
    }

    static void comb(int cnt, int curr){
        if(cnt == N / 2){
            int startScore = 0;
            int linkScore = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(selected[i] && selected[j]){
                        startScore += score[i][j];
                    } else if(!selected[i] && !selected[j]){
                        linkScore += score[i][j];
                    }
                }
            }
            ans = Math.min(ans, Math.abs(startScore - linkScore));
            return;
        }

        for(int i = curr; i < N; i++){
            selected[i] = true;
            comb(cnt + 1, i + 1);
            selected[i] = false;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int totalPeople = 0;
    static int answer;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                totalPeople += map[i][j];
            }
        }
        for (int x = 0; x < N; x++) { // 기준점 x
            for (int y = 0; y < N; y++) { // 기준점 y
                // 조건을 만족 하는가? d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N
                for (int d1 = 1; d1 < N; d1++) { // 경계선 길이 d1
                    for (int d2 = 1; d2 < N; d2++) { // 경계선 길이 d2
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;
                        gerrymandering(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static void gerrymandering(int x, int y, int d1, int d2) {
        boolean[][] boundary = new boolean[N][N];
        for (int i = 0; i <= d1; i++) { // 경계선 1번 조건과 3번 조건
            boundary[x + i][y - i] = true;
            boundary[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) { // 경계선 2번 조건과 4번 조건
            boundary[x + i][y + i] = true;
            boundary[x + d1 + i][y - d1 + i] = true;
        }
        int[] peopleSum = new int[5];
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (boundary[i][j]) break;
                peopleSum[0] += map[i][j];
            }
        }
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (boundary[i][j]) break;
                peopleSum[1] += map[i][j];
            }
        }
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (boundary[i][j]) break;
                peopleSum[2] += map[i][j];
            }
        }
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (boundary[i][j]) break;
                peopleSum[3] += map[i][j];
            }
        }
        int MIN = Integer.MAX_VALUE;
        int MAX = Integer.MIN_VALUE;
        peopleSum[4] = totalPeople;
        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }
        for(int i = 0; i <= 4; i++){
            MIN = Math.min(peopleSum[i], MIN);
            MAX = Math.max(peopleSum[i], MAX);
        }
        answer = Math.min(answer, MAX - MIN);
    }
}
package day1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
    /**
     * N x M 보드
     * 체스판으로 만들기 위해 색칠해야 하는 정사각형의 최소 개수 구하기
     *
     * 체스판 색칠하는 경우는 단 2가지
     * -> 미리 세팅해두고 주어진 보드 잘라보면서 비교
     */
    static int N, M, ans;
    static char[][] board;
    static char[][] chess1 = new char[][] {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };
    static char[][] chess2 = new char[][]{
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        board = new char[N][M];
        for(int i = 0; i < N; i++){
            board[i] = br.readLine().toCharArray();
        } // 입력 끝

        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                checkBoard(i, j);
            }
        }
        System.out.println(ans);
    }
    // 현재 선택한 8x8보드 체스판처럼 만드려면 몇칸 색칠해야하는지 확인
    static void checkBoard(int si, int sj){
        int check1 = 0; // chess1 처럼 만드려면 몇 개 색칠해야하는지
        int check2 = 0; // chess2 처럼 만드려면 몇 개 색칠해야하는지
        for(int i = si; i < si + 8; i++){
            for(int j = sj; j < sj + 8; j++){
                check1 = (board[i][j] == chess1[i - si][j - sj]) ? check1 : check1 + 1;
                check2 = (board[i][j] == chess2[i - si][j - sj]) ? check2 : check2 + 1;
            }
        }
        ans = Math.min(ans, Math.min(check1, check2));
    }
}

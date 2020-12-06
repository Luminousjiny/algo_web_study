package day1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 체스판칠하기
public class BOJ1018 {
    static StringTokenizer st;
    static char[][] map, Ws, Bs;
    static int MIN;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //열
        int M = Integer.parseInt(st.nextToken()); //행
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            map[i] = S.toCharArray();
        }

        Ws = new char[8][8]; // W로 시작하는 체스판 세팅
        Bs = new char[8][8]; // B로 시작하는 체스판 세팅
        for (int i = 0; i < 8; i+=2) {
            String P1 = "WBWBWBWB";
            Ws[i] = P1.toCharArray();
            Bs[i+1] = P1.toCharArray();
        }
        for (int i = 0; i < 8; i+=2) {
            String P2 = "BWBWBWBW";
            Ws[i+1] = P2.toCharArray();
            Bs[i] = P2.toCharArray();
        }

        MIN = Integer.MAX_VALUE;
        // 시작점을 0,0 ~> M-7,N-7 까지 이동
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                int cnt = Count(i, j);
                MIN = Math.min(MIN, cnt);
            }
        }
        System.out.println(MIN);

    }
    static int Count(int sx, int sy){ // 사작점 넘기기
        // Ws, Bs 배열 모두 비교해보고 최소값 return
        int Wcnt = 0, Bcnt = 0;
        for (int i = sx; i < sx+8; i++) {
            for (int j = sy; j < sy+8; j++) {
                if(map[i][j] != Ws[i-sx][j-sy]){
                    Wcnt++;
                }
                if(map[i][j] != Bs[i-sx][j-sy]){
                    Bcnt++;
                }
            }
        }
        int minCnt = Math.min(Wcnt, Bcnt);
        return  minCnt;
    }
}

package day1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 3차원 토마토
public class BOJ7569 {
    static StringTokenizer st;
    static int[][][] box;
    static int[] di = {-1,1,0,0}; // 상 하 좌 우
    static int[] dj = {0,0,-1,1};
    static int day;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 열
        int N = Integer.parseInt(st.nextToken()); // 행
        int H = Integer.parseInt(st.nextToken()); // 높이
        box = new int[H][N][M];
        int zero = 0;
        Queue<Point> qu = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    box[i][j][k] = num;
                    if(num == 0) zero++;
                    if(num == 1) {
                        qu.add(new Point(i, j, k)); // 1인 지점 qu에 먼너 젛기
                        box[i][j][k] = 9;
                    }
                }
            }
        }
        if(zero == 0 ){
            System.out.println(0);
        }else{
            // 1 : 익은 토마토 / 0 : 안익은 토마토 / -1 : 빈칸
            // 모든 1을 시작점으로 잡고 BFS
            // 1을 상 하 좌 우 위 아래 로 6방향 탐색해서 0인 칸을 9로 만들기
            // size 마다 day ++
            // BFS 탐색이 종료되고 0이 남아있으면 -1, 아니면 day 출력
            while (!qu.isEmpty()){
                int size = qu.size();
                for (int s = 0; s < size; s++) {
                    Point now = qu.poll();
                    for (int dir = 0; dir < 4; dir++) { // 상하좌우
                        int ni = now.x + di[dir];
                        int nj = now.y + dj[dir];
                        if(ni>=0 && ni<N && nj>=0 && nj<M && (box[now.h][ni][nj] == 0 || box[now.h][ni][nj] == 1)){
                            qu.add(new Point(now.h, ni, nj));
                            box[now.h][ni][nj] = 9; // 익히기
                        }
                    }
                    // 위
                    int hu = now.h -1;
                    if(hu >=0 && hu <H && (box[hu][now.x][now.y] == 0||box[hu][now.x][now.y] == 1)){
                        qu.add(new Point(hu, now.x, now.y));
                        box[hu][now.x][now.y] = 9; // 익히기
                    }
                    // 아래
                    int hd = now.h +1;
                    if(hd >=0 && hd <H && (box[hd][now.x][now.y] == 0||box[hd][now.x][now.y] == 1)){
                        qu.add(new Point(hd, now.x, now.y));
                        box[hd][now.x][now.y] = 9; // 익히기
                    }
                }
                day ++;
            }

            boolean ans = true;
            loop :
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if(box[i][j][k] == 0){
                            ans = false;
                            break loop;
                        }
                    }
                }
            }
            if(ans) System.out.println(day-1);
            else System.out.println(-1);
        }
    }
    static class Point{
        int x, y, h;
        Point( int h, int x, int y){
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
}

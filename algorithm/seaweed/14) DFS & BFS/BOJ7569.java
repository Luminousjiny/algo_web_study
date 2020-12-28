package day1226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    /**
     * 3차원 토마토
     * 1 : 익토
     * 0 : 안익토
     * -1 : 빈 칸
     * 토마토는 적어도 하나 이상 존재
     * N x M x H
     * 2 <= N, M <= 100
     * 1 <= H <= 100
     */
    static int N, M, H, restTomato, ans; // 행, 열, 높이, 덜익은 토마토 개수, 다 익는데 걸리는 시간
    static int[] di = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dj = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dh = {1, -1}; // 앞 뒤
    static int[][][] box;
    static Queue<Point> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[N][M][H];
        queue = new LinkedList<>();
        restTomato = 0;
        ans = -1;

        for (int h = 0; h < H; ++h) {
            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; ++j) {
                    box[i][j][h] = Integer.parseInt(st.nextToken());
                    if(box[i][j][h] == 1) // 토마토면 큐에 넣어둠
                        queue.add(new Point(i, j, h));
                    else if (box[i][j][h] == 0) { // 덜익은 토마토 개수
                        ++restTomato;
                    }
                }
            }
        } // 입력 끝

        bfs();
        System.out.println(restTomato == 0 ? ans : -1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; ++s) {
                Point curr = queue.poll();

                // 상 하 좌 우 체크
                for (int d = 0; d < 4; ++d) {
                    int ni = curr.i + di[d];
                    int nj = curr.j + dj[d];

                    if (checkIsValidRange(ni, nj, curr.h)) {
                        box[ni][nj][curr.h] = 1;
                        --restTomato;
                        queue.add(new Point(ni, nj, curr.h));
                    }
                }
                // 앞 뒤 체크
                for (int d = 0; d < 2; ++d) {
                    int nh = curr.h + dh[d];

                    if (checkIsValidRange(curr.i, curr.j, nh)) {
                        box[curr.i][curr.j][nh] = 1;
                        --restTomato;
                        queue.add(new Point(curr.i, curr.j, nh));
                    }
                }
            }
            ++ans;
        }
    }

    static boolean checkIsValidRange(int ni, int nj, int nh) {
        return ni >= 0 && ni < N && nj >= 0 && nj < M && nh >= 0 && nh < H && box[ni][nj][nh] == 0;
    }

    static class Point {
        int i, j, h;

        public Point(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }
}

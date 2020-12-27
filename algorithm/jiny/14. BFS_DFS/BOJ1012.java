package day1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 유기농 배추
// 상 하 좌 우 이동하여 덩어리 개수 찾기
public class BOJ1012 {
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visit;
    static int bugCnt; // 배추흰지렁이 개수
    static int[] di = {-1,1,0,0}; // 상 하 좌 우
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테케
        for (int TC = 1; TC <= T; TC++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 열
            int N = Integer.parseInt(st.nextToken()); // 행
            int K = Integer.parseInt(st.nextToken()); // 배추 심어진 위치 개수
            map = new int[N][M]; // 배추 판
            // 배추판에 심어진 부분을 1로 채우기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 열 좌표
                int Y = Integer.parseInt(st.nextToken()); // 행 좌표
                map[Y][X] = 1;
            }
            bugCnt = 0;
            visit = new boolean[N][M]; // 방문체크
            // bfs 로 덩어리 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visit[i][j]){ // 방문 안한 배추발견
                        Queue<Point> qu = new LinkedList<>();
                        qu.add(new Point(i,j)); // 시작점 큐에 넣고
                        visit[i][j] = true; // 시작점 방문처리
                        while (!qu.isEmpty()){ // 큐가 빌 때까지 반복
                            Point now = qu.poll();
                            for (int dir = 0; dir < 4; dir++) { // 사방탐색
                                int ni = now.x + di[dir];
                                int nj = now.y + dj[dir];
                                if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj]==1 && !visit[ni][nj]){ // 범위 내이고, 방문안한 배추면
                                    qu.add(new Point(ni, nj)); // 큐에 넣고
                                    visit[ni][nj] = true; // 방문처리
                                }
                            }
                        }
                        bugCnt ++; // 지렁이 수 증가
                    }
                }
            }
            System.out.println(bugCnt);
        }
    }
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}

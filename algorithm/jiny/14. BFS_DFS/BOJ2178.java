package day1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int[][] map;
    static StringTokenizer st;
    static int move;
    static int[] di = {-1,1,0,0}; // 상 하 좌 우
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1]; // 인덱스 1부터 시작
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        // 최소 길이를 구하는 것 -> BFS
        Queue<Point> qu = new LinkedList<>();
        boolean ck = false;
        qu.add(new Point(1,1));
        map[1][1] = 0;
        while (!qu.isEmpty()){
            int size = qu.size();
            for (int s = 0; s < size; s++) {
                Point now = qu.poll();
                if(now.x == N && now.y == M) {
                    ck = true;
                    break;
                }
                for (int dir = 0; dir < 4; dir++) { // 사방탐색
                    int ni = now.x + di[dir];
                    int nj = now.y + dj[dir];
                    if(ni>0 && ni<=N && nj>0 && nj<=M && map[ni][nj]==1 ){ // 범위 내이고, 1이면
                        qu.add(new Point(ni, nj)); // 큐에 넣고
                        map[ni][nj] = 0;
                    }
                }
            }
            move++;
            if(ck) break;
        }
        System.out.println(move);
    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

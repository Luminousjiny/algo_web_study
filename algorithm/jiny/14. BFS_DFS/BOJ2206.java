package day1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 벽부수고 이동하기
public class BOJ2206 {
    static StringTokenizer st;
    static int N, M; // 행,열
    static String s;
    static int [][]map; //맵
    static int [][][]visit; //행,열,부수고(1)/안부수고(0) 여부 기록
    static int[] di = {-1,1,0,0}; //상,하,좌,우
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }//map 배열 채우기
        visit = new int[N][M][2];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                for(int k=0; k<2; k++) { //0이면 안부시고 간 거리 / 1이면 부시고간 거리 기록
                    visit[i][j][k] = Integer.MAX_VALUE; //거리 기록을 일단 최대로 셋팅
                }
            }
        }

        Queue<Point> qu = new LinkedList<>();
        qu.add(new Point (0,0,0)); // 0,0,부시기X
        visit[0][0][0] = 1; // 0,0에서 출발 ! 부시지 않을 때
        visit[0][0][1] = 1; // 부실 때 각각 거리 1로 셋팅

        while(!qu.isEmpty()) {
            Point now = qu.poll();
            for(int dir =0; dir<4; dir++) {
                int ni = now.x +di[dir];
                int nj = now.y +dj[dir];
                // 범위내에, 옆칸 ni,nj가 빈칸이고, 그 칸까지의 거리보다 지금 now가 더 빠를 때 (벽을 부시던 안부시던) dir방향으로 이동한 칸의 거리 > 이동하지 않은 칸의 거리 +1
                if(check(ni,nj) && map[ni][nj] ==0 && visit[ni][nj][now.wall] > visit[now.x][now.y][now.wall]+ 1) {
                    visit[ni][nj][now.wall] = visit[now.x][now.y][now.wall]+1; // 짧은 거리로 갱신
                    qu.add(new Point(ni,nj,now.wall)); //갱신한 지점으로 추가
                }else if(check(ni,nj) && map[ni][nj] ==1 && now.wall ==0) { //범위내에, 옆칸 ni,nj가 벽이고, 부시지 않았으면
                    visit[ni][nj][1] = visit[now.x][now.y][0] +1; //부순경우의 칸에 전칸+1 거리 기록
                    qu.add(new Point(ni, nj, 1)); //갱신지점 추가
                }
            }//dir
        }//qu -> while

        int ans = Math.min(visit[N-1][M-1][0], visit[N-1][M-1][1]); // 안부시고 갔을 때, 부시고갔을때 최소거리
        System.out.println(ans==Integer.MAX_VALUE ? -1 : ans); //셋팅그대로면 못간거니까 -1, 아니면 이동한 최소거리
    }

    static boolean check(int i, int j) { /** 범위체크 메소드 */
        if(i>=0 && i<N && j>=0 && j<M) {
            return true; //범위 내면 true
        }
        return false; //아니면 false
    }

    public static class Point{
        int x, y, wall; //좌표x,y, 벽부쉈는지 횟수(0 / 1)
        Point (int x, int y, int wall){
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

}

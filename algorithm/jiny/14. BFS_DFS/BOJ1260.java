package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// BFS, DFS 구현
public class BOJ1260 {
    static StringTokenizer st;
    static int N, M, V; // 정점수, 간선수, 시작점
    static int[][] number; //연결여부
    static boolean[] visit1;//방문여부
    static boolean[] visit2;//방문여부
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        number = new int[N+1][N+1];
        visit1 = new boolean[N+1];
        visit2 = new boolean[N+1];
        for(int i=0; i<M; i++) {//간선 수만큼 연결 점 입력
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            number[s][e] = number[e][s] = 1; //양방향
        }
        dfs(V);
        System.out.println();
        bfs(V);

    }

    public static void bfs(int start) {
        Queue<Integer> qu = new LinkedList<Integer>();

        qu.add(start);
        while(!qu.isEmpty()) {
            int now = qu.poll();
            visit1[now] = true;
            System.out.print(now+" ");
            for(int i=1; i<=N; i++) {
                if(number[now][i]== 1 && !visit1[i]) {
                    qu.add(i);
                    visit1[i] = true;
                }
            }

        }//while
    }

    public static void dfs(int start) {
        visit2[start] = true;
        System.out.print(start+" ");
        for(int i=1; i<=N; i++) {
            if(number[start][i] ==1 && !visit2[i]) {
                dfs(i);
            }
        }
    }
}

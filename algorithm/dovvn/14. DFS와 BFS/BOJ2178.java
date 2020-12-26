import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//dfs로 푸니 시간초과남 => 최단거리일때는 bfs 사용하기
public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited; //방문 기록
    static int[] di = {-1, 1, 0, 0}; //상하좌우
    static int[] dj = {0, 0, -1, 1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }//End input

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0));
        map[0][0] = 1;
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + di[d];
                int ny = p.y + dj[d];

                //현재까지 온 칸 수가 더 많거나 같을때만 큐에 넣기
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 0 && !visited[nx][ny]) {
                    map[nx][ny] = map[p.x][p.y] + 1; //현재까지 온 칸수 + 1
                    visited[nx][ny] = true; //방문처리
                    queue.add(new Point(nx, ny));
                }
            }//End 4방향 탐색
        }//End BFS

        System.out.println(map[N-1][M-1]);
    }
}
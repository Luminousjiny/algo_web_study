import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int Ans; //최소일수
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

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Queue<Point> queue = new LinkedList<>();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) queue.add(new Point(i, j));
            }
        }//End input

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point p = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = p.x + di[d];
                    int ny = p.y + dj[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                        map[nx][ny] = 1; //익었음 표시
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            Ans++;
        }//End BFS

        boolean allRipe = true;
        for(int i=0; i<N; i++){ //모두 익었는지 검사
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    allRipe = false;
                    break;
                }
            }
        }
        System.out.println((allRipe ? Ans-1 : -1));
    }
}
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H;
    static int[][][] map;
    static int Ans; //최소일수
    static int[] di = {0, 0, 0, 0, -1, 1}; // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    static int[] dj = {0, 0, -1, 1, 0, 0};
    static int[] dh = {-1, 1, 0, 0, 0, 0};

    static class Point {
        int x;
        int y;
        int h;

        public Point(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Queue<Point> queue = new LinkedList<>();

        map = new int[H][N][M];

        for (int h = 0; h < H; h++) { //층
            for(int i=0; i<N; i++){ //세로
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){ //가로
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if(map[h][i][j] == 1) queue.add(new Point(i, j, h));
               }
            }
        }//End input

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point p = queue.poll();

                for (int d = 0; d < 6; d++) {
                    int nh = p.h + dh[d];
                    int nx = p.x + di[d];
                    int ny = p.y + dj[d];

                    if ( nh>=0 && nh<H && nx >= 0 && nx < N && ny >= 0 && ny < M && map[nh][nx][ny] == 0) {
                        map[nh][nx][ny] = 1; //익었음 표시
                        queue.add(new Point(nx, ny, nh));
                    }
                }
            }
            Ans++;
        }//End BFS

        boolean allRipe = true;
        for(int h=0; h<H; h++){ //검사
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[h][i][j] == 0){
                        allRipe = false;
                        break;
                    }
                }
            }
        }
        System.out.println((allRipe ? Ans-1 : -1));
    }
}
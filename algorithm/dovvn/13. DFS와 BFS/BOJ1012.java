import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

    static int T;
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited; //방문했는지
    static int[] di = {-1, 0, 1, 0}; //시계방향
    static int[] dj = {0, 1, 0, -1};
    static int Ans; //최소 흰지렁이수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken()); //세로
            K = Integer.parseInt(st.nextToken()); //배추개수

            map = new int[N][M];
            visited = new boolean[N][M];
            Ans = 0;

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }//input 배추

            //dfs
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        visited[i][j] = true;
                        dfs(i ,j);
                        Ans++;
                    }
                }
            }
            bw.write(Ans+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int i, int j) {

        //4방향 탐색
        for(int d=0; d<4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];

            if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj]==1 && !visited[ni][nj]) {
                visited[ni][nj] = true;
                dfs(ni, nj);
            }
        }
    }
}
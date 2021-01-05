import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//색종이 만들기
public class Main {

    static int N;
    static int[][] map;
    static int[][] ans = new int[1][2];

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
       map = new int[N+1][N+1];

       for(int i=1; i<=N; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j=1; j<=N; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
           }
       }//input i,j

        divide(1, 1, N);

        System.out.println(ans[0][0]+"\n"+ans[0][1]);

    }

    static void divide(int x, int y, int size){
        //size가 1개
        if(size==1){
            ans[0][map[x][y]] += 1;
            return;
        }

        //N/2 * N/2 나누기
        //1사분면
        if(!check(x,y, size/2)) divide(x, y, size/2);

        //2사분면
        if(!check(x,y+size/2, size/2)) divide(x, y+size/2, size/2);

        //3사분면
        if(!check(x+size/2,y, size/2)) divide(x+size/2, y, size/2);

        //4사분면
        if(!check(x+size/2,y+size/2, size/2)) divide(x+size/2, y+size/2, size/2);

    }

    //같은 색종이 수 있는지 확인
    static boolean check(int x, int y, int size){
        int color = map[x][y];

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(map[i][j] != color){
                    return false;
                }
            }
        }

        ans[0][map[x][y]] += 1; //색깔 맞춰서 색종이수 합치기
        return true;
    }
}
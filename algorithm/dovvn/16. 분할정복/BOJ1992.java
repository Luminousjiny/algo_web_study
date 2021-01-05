import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//쿼드트리
public class Main {

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
       map = new int[N+1][N+1];

       int num = 0;

       for(int i=1; i<=N; i++){
           String s = br.readLine();
           for(int j=1; j<=N; j++){
               map[i][j] = s.charAt(j-1)-'0';
           }
       }//End input

       if(!check(1, 1, N)) divide(1, 1, N);
        System.out.println(sb+"");
    }

    static void divide(int x, int y, int size){
        //size==1인 경우
        if(size==1){
            sb.append(map[x][y]);
            return;
        }

        sb.append("(");

        //1사분면
        if(!check(x, y, size/2)) divide(x, y, size/2);

        //2사분면
        if(!check(x, y+size/2, size/2)) divide(x, y+size/2, size/2);

        //3사분면
        if(!check(x+size/2, y, size/2)) divide(x+size/2, y, size/2);

        //4사분면
        if(!check(x+size/2, y+size/2, size/2)) divide(x+size/2, y+size/2, size/2);

        sb.append(")");
    }

    static boolean check(int x, int y, int size){
        int num = map[x][y]; //첫번째 숫자

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(map[i][j]!=num){
                    return false;
                }
            }
        }

        //모두 같은 숫자 => 하나로 압축
        sb.append(num);
        return true;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//신나는 함수 실행
public class Main {

    static int a, b, c;
    static final int MAX = 50;
    static int[][][] dp = new int[MAX+1][MAX+1][MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int a, b, c;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;
            sb.append("w("+a+", "+b+", "+c+") = "+w(a, b, c) + "\n");
        }//End input

        System.out.println(sb + "");
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if(dp[a][b][c]!=0) return dp[a][b][c]; //이미 메모이제이션으로 값이 구해졌다면 반환
        else if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        else if (a < b && b < c) dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        else dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return dp[a][b][c];
    }
}
package day1203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1541 {
    /**
     * 빼기를 최대한 많이 하자
     */
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer splitMinus = new StringTokenizer(br.readLine(), "-"); // - 기준으로 분리
        ans = 0;
        boolean first = true;
        while(splitMinus.hasMoreTokens()){
            StringTokenizer splitPlus = new StringTokenizer(splitMinus.nextToken(), "+");
            int tmp = 0;
            while(splitPlus.hasMoreTokens()){
                tmp += Integer.parseInt(splitPlus.nextToken());
            }
            if (first) { // 처음은 -가 안됨 더해줘야함
                ans += tmp;
                first = false;
            } else {
                ans -= tmp;
            }
        }
        System.out.println(ans);
    }
}

package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 소트인사이드
public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] num = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            num[i] = S.charAt(i) -'0';
        }
        Arrays.sort(num);
        for (int i = S.length()-1; i >= 0; i--) {
            System.out.print(num[i]);
        }

    }
}

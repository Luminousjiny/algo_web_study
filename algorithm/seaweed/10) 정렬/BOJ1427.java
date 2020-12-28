package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1427 {
    static char[] charArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        charArr = br.readLine().toCharArray();

        Arrays.sort(charArr);

        System.out.println(new StringBuilder(new String(charArr)).reverse().toString());
    }
}

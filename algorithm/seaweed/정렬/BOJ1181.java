package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1181 {
    static int N;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for(int i = 0; i < N; ++i){
            words[i] = br.readLine();
        }

        Arrays.sort(words, (a, b) -> {
            if(a.length() == b.length())
                return a.compareTo(b);
            return a.length() - b.length();
        });

        for(int i = 0; i < N; ++i){
            if(i == 0)
                sb.append(words[i]).append("\n");
            else if(!words[i-1].equals(words[i]))
                sb.append(words[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}

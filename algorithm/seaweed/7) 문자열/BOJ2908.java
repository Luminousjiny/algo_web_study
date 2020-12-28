package day1129;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 원본 수
        String ogA = st.nextToken();
        String ogB = st.nextToken();
        // 상수가 읽는 수
        String sangsuA = "";
        String sangsuB = "";
        // 원본 수를 상수가 읽는 수로 변환(reverse)
        for(int i = 2; i >= 0; i--){
            sangsuA += ogA.charAt(i);
            sangsuB += ogB.charAt(i);
        }
        System.out.println((Integer.parseInt(sangsuA) > Integer.parseInt(sangsuB)) ? sangsuA : sangsuB);
    }
}

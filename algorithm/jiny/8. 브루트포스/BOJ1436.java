package day1206;

import java.util.Scanner;

// 숫자 사이 어디든 666이 들어가야함
// 그중에서 N번째 값 찾기
public class BOJ1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        int i = 666;
        while (true) {
            String S = Integer.toString(i);
            if(S.contains("666")){
                cnt++;
            }
            if(cnt == N) {
                System.out.println(i);
                break;
            }
            i++;
        }

    }
}

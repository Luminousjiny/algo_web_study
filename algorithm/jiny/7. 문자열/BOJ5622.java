package day1203;

import java.util.Scanner;

public class BOJ5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        // 65-90 : A-Z
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            int time = 2;
            for (int j = 67; j < 91; j+=3) {
                if(j==82 || j==89) j++;
                time ++;
                if(S.charAt(i) <= j){
                    sum += time;
                    break;
                }
            }
        }
        System.out.println(sum);

    }
}

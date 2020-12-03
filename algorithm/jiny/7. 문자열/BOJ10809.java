package day1203;

import java.util.Scanner;

public class BOJ10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] alpa = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            alpa[i] = (int)s.charAt(i);
        }
        int[] ans = new int[123]; // 97-122 : a-z
        for (int i = 97; i < 123; i++) {
            ans[i] = -1;
        }

        for (int i = 97; i < 123; i++) {
            for (int j = 0; j < alpa.length; j++) {
                if(alpa[j] == i){
                    ans[i] = j;
                    break;
                }
            }
        }

        for (int i = 97; i < 123; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}

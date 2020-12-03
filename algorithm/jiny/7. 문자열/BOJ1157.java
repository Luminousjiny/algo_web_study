package day1203;

import java.util.Scanner;

public class BOJ1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();

        // 65-90 : A-Z
        int[] alpa = new int[91];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 65; j < 91; j++) {
                if((int)s.charAt(i) == j){
                    alpa[j] ++;
                }
            }
        }

        int max = alpa[0];
        for (int i = 0; i < alpa.length; i++) {
            if(max < alpa[i]){
                max = alpa[i];
            }
        }

        int cnt = 0;
        for (int i = 0; i < alpa.length; i++) {
            if(max == alpa[i]){
                cnt ++;
            }
        }
        if(cnt == 1){
            for (int i = 0; i < alpa.length; i++) {
                if(max == alpa[i]){
                    System.out.println((char)i);
                }
            }
        }else{
            System.out.println("?");
        }



    }
}

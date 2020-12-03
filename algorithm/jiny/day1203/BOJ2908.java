package day1203;

import java.util.Scanner;

public class BOJ2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int max = Math.max(Integer.parseInt(change(a)), Integer.parseInt(change(b)));
        System.out.println(max);
    }
    static String change(String s){
        String tmp = "";
        for (int i = 2; i >= 0; i--) {
            tmp += s.charAt(i);
        }
        return tmp;
    }
}

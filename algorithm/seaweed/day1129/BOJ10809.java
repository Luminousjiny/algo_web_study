package day1129;

import java.util.Scanner;

public class BOJ10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String word = sc.next();
        for(int i = 97; i <= 122; i++){
            sb.append(word.indexOf((char)i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}

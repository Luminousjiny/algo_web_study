package day1129;

import java.util.Scanner;

public class BOJ2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        word = word.replaceAll("c=", "c");
        word = word.replaceAll("c-", "c");
        word = word.replaceAll("dz=", "d");
        word = word.replaceAll("d-", "d");
        word = word.replaceAll("lj", "l");
        word = word.replaceAll("nj", "n");
        word = word.replaceAll("s=", "s");
        word = word.replaceAll("z=", "z");

        System.out.println(word.length());
    }
}

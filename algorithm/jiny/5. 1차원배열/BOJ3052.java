package day1204;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mod = new int[10];
        for (int i = 0; i < 10; i++) {
            mod[i] = sc.nextInt()%42;
        }

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            hashSet.add(Integer.toString(mod[i]));
        }

        System.out.println(hashSet.size());
    }
}

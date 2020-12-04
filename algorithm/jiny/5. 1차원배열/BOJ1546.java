package day1204;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] score = new double[N];
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }
        Arrays.sort(score);
        double M = score[N-1]; // 최대값

        for (int i = 0; i < N; i++) {
            score[i] = score[i]/M*100;
        }
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += score[i];
        }
        System.out.println(sum/N);

    }
}

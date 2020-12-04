package day1204;

import java.util.Scanner;

public class BOJ4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int TC = 0; TC < C; TC++) {
            int N = sc.nextInt(); // 학생수
            int[] stu = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                stu[i] = sc.nextInt();
                sum += stu[i];
            }
            double p = (double) sum/N; // 평균
            int stuCnt = 0;
            for (int i = 0; i < N; i++) {
                if(stu[i]>p) stuCnt++;
            }

            double v = (double)stuCnt/N*100;
            String per = String.format("%.3f",v);
            System.out.println(per+"%");
        }
    }
}

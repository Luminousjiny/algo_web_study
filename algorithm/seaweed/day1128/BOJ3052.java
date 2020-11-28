package day1128;

import java.util.Scanner;

public class BOJ3052 {

    static boolean[] check;
    static int count;
    static final int N = 42;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        check = new boolean[N];

        for(int i = 0; i < 10; i++){
            int curr = sc.nextInt();

            // 42로 나눈 나머지가 이전에 없던 수면 개수 1증가
            if(!check[curr % N]){
                check[curr % N] = true;
                count++;
            }
        }
        System.out.println(count);
    }
}

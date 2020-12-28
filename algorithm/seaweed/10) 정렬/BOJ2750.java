package day1208;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ2750 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}

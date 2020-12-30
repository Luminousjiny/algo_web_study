import java.util.Arrays;
import java.util.Scanner;

//수찾기: 라이브러리ver
public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        arr = new int[N];

        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        M = sc.nextInt();

        Arrays.sort(arr); //이분탐색에선 반드시 정렬

        for(int i=0; i<M; i++){
            int target = sc.nextInt();

            sb.append(Arrays.binarySearch(arr, target) > -1 ? "1\n" : "0\n");
        }

        System.out.println(sb);
    }
}
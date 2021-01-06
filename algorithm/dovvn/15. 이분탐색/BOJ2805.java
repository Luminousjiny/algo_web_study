import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M; //나무개수, 가져가려는 나무길이
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt(); //End input

        Arrays.sort(arr);

        long left = 1; //절단기 설정할 높이 최소값
        long right = arr[N-1]; //절단기 설정할 높이 최대값
        long mid = 0;

        //절단기 설정할 높이 최대값 탐색
        while(left <= right){
            mid = (left + right) / 2;

            long sum = 0; //절단한 나무길이 합
            //절단해주기
            for(int i=0; i<N; i++){
                if(arr[i] <= mid) continue;
                sum += arr[i] - mid;
            }

            if(sum>=M) left = mid + 1; //구하고자하는 높이보다 길면 더 길게 잘라주기
            else right = mid - 1;
        }//End 이분탐색

        System.out.println(right);


    }
}
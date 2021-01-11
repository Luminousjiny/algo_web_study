import java.util.Arrays;
import java.util.Scanner;

//정수 삼각형
/*
선택된 수의 합이 최대가 되도록
아래층의 수는 현재 층에서 선택된 양쪽 대각선만 가능
 */
public class Main {

    static int n; //삼각형의 크기
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                arr[i][j]  = sc.nextInt();
                if(i==0) continue;
                else if(j==0) arr[i][j] = arr[i-1][j] + arr[i][j];
                else arr[i][j] = Math.max(arr[i-1][j-1],arr[i-1][j]) + arr[i][j];
            }
        }//End input

        Arrays.sort(arr[n-1]);
        System.out.println(arr[n-1][n-1]);
    }
}
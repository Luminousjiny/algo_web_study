import java.util.Scanner;

//가장 긴 바이토닉 부분 수열
public class Main {

    static int n; //삼각형의 크기
    static int[] arr;
    static int[] f;
    static int[] r;
    static int Ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];

        //현재 인덱스값의 증가하는 수열의 길이 저장
        f = new int[n];
        r = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        //맨앞부터 LIS구하기
        for(int i=0; i<n; i++){
            f[i] = 1; //초기 길이1
            for(int j=0; j<i; j++){ //현재 인덱스 이전에서 현재 원소값보다 더 작은 원소를 찾는다.
                if(arr[j] < arr[i] && f[j]+1>f[i]) f[i]++; //선택 시 길이가 증가하면 갱신
            }
        }

        //맨뒤부터 LIS구하기
        for(int i=n-1; i>=0; i--){
            r[i] = 1; //초기 길이1
            for(int j=n-1; j>i; j--){ //현재 인덱스 이전에서 현재 원소값보다 더 작은 원소를 찾는다.
                if(arr[j] < arr[i] && r[j]+1>r[i]) r[i]++; //선택 시 길이가 증가하면 갱신
            }
        }

        //두 LIS의 합의 최대값 구하기
        for(int i=0; i<n; i++) Ans = Math.max(Ans, f[i] + r[i]);

        System.out.println(Ans-1); //가운데값이 겹치므로 하나뺌
    }
}
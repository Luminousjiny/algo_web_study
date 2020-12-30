import java.util.Arrays;
import java.util.Scanner;

//수찾기: 구현ver
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
            sb.append(binarySearch(target)+"\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int target){
        int first = 0; //첫번째 인덱스
        int last = arr.length-1; //마지막 인덱스
        int mid; //가운데 인덱스

        while(first <= last){
            //1. 배열의 중간값을 탐색한다.
            mid = (first + last) / 2;

            //2. 중간값이 탐색값이면 중단
            if(arr[mid] == target) return 1;
            else{//3. 중간값이 탐색값이 아니면 크기 비교
                //4. 탐색값 < 중간값: 중간값의 오른쪽 인덱스 제외
                if(target < arr[mid]) last = mid-1;
                //5. 탐색값 > 중간값: 중간값의 왼쪽 인덱스 제외
                else first = mid + 1;
            }
        }
        return 0; //끝까지 탐색하면 찾지 못한 경우로 0리턴
    }
}
import java.util.Arrays;
import java.util.Scanner;

//공유기설치
public class Main {

    static int N,C; //집, 공유기 개수
    static int[] houses; //집 거리 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //집 개수
        C = sc.nextInt(); //공유기 개수

        houses = new int[N]; //집 거리 배열
        for(int i = 0; i < N; i++) houses[i] = sc.nextInt(); //End input

        Arrays.sort(houses); //거리순 오름차순 정렬

        int left = 1; //가장 인접한 두 공유기 최소거리
        int right = houses[N-1] - houses[0]; //최대거리
        int mid = 0;

        while(left <= right) {
            int cnt = 1; //설치한 공유기 개수
            int prev = houses[0]; //방금 설치한 집의 거리
            mid = (left + right) / 2; //중간값 => 설치 거리

            for(int house : houses) {//공유기 설치할 집 탐색
                if(prev + mid <= house) { //방금 설치한 집의 거리+설치 거리보다 크면 설치가능
                    cnt++;
                    prev = house;
                }
            }

            if(cnt >= C) left = mid + 1; //공유기가 더 많이 설치됐으므로 간격 더 넓게
            else right = mid - 1;
        }
        System.out.print(right);
    }
}
package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2750_quickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        // 중간지점을 pivot 로 잡고 양쪽으로 나눔
        // start(num[0]), end(num[N-1]) 를 정하고 pivot 기준으로 이동
        // start 지점을 이동 pivot 보다 큰수가 나오면 멈추고
        // end 지점을 이동 pivot 보다 작으면 start 값이랑 swap
        // 값을 바꾼 후 start 지점 +1 , end 지점 -1 이동
        // 각각 나뉜 배열 같은 작업 반복
        // 방이 1개가 되면 끝

        quickSort(num, 0, N-1); // 배열, 시작점, 끝점
        for (int i = 0; i < N; i++) {
            System.out.println(num[i]);
        }

    }
    // 퀵 정렬 -> 나눈 배열의 원소가 1개가 남으면 끝
    private static void quickSort(int[] arr, int start, int end) {
        int part2start = part(arr, start, end); // 오른쪽 배열 시작점
        if(start < part2start-1){ // 왼쪽 배열의 원소가 1개가 아님
            // 시작점 그대로, 끝나는 지점은 오른쪽 배열 시작점-1
            quickSort(arr, start, part2start-1);
        }
        if(part2start < end){ // 오른쪽 배열의 원소가 1개가 아님
            // 시작점은 오른쪽 배열의 시작점, 끝나는 지점은 그대로
            quickSort(arr, part2start, end);
        }
    }

    // 배열이 들어오면 반으로 나눠서 오른쪽 배열 첫번째 인덱스 반환
    private static int part(int[] arr, int start, int end) {
        int pivot = arr[(start+end)/2]; // 가운데 지점
        while (start <= end){
            while (arr[start] < pivot) start++; // pivot 보다 같거나 커지기 전까지 start 증가
            while (arr[end] > pivot) end--; // pivot 보다 작거나 같아지기 전까지 end 감소
            if(start <= end){ // 두 지점이 지나치지 않았는지 확인
                swap(arr, start, end); // 두지점의 숫자 바꾸기
                // 값을 바꾼 후 start 지점 +1 , end 지점 -1 이동
                start++;
                end--;
            }
        }
        return start;
    }
    // 값 두개 바꾸는 메소드
    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}

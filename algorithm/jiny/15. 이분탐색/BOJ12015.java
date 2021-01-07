package day0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 가장 긴 증가하는 부분 수열 2
// 1. 그냥 구현... 당연히 터져버림...
// 2. LIS 알고리즘(최장증가수열 알고리즘)... >>> dp... >>> 마지막 수가 x 번째인 가장 긴 최장증가수열
//     ... 이중 for문 쓰면 터짐...N^2 ㅅ;간복잡도
// 3. LIS 알고리즘(최장증가수열 알고리즘)... >>> dp... >>> 길이가 x인 최장증가수열의 마지막 수의 최소값
//          ... 시간복잡도...nlogn
public class BOJ12015 {
    static StringTokenizer st;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 A의 길이
        st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(arr.isEmpty()) arr.add(num); // 리스트가 비어있으면 넣어줌
            else { // 데이터가 있을 경우
                if(arr.get(arr.size()-1) >= num){ // 가장 마지막 원소가 입역 값보다 크면
                    // 입력값 보다는 큰, 가장 작은 값 찾고 그 자리에 넣기 -> 이분탐색
                    binary(0, arr.size()-1, num); // 시작, 끝 인덱스, 입력 값으로 이분탐색 시작
                }else arr.add(num); // 입력값이 더 크다면 그냥 뒤에 추가
            }
        }
        System.out.println(arr.size());
    }

    static void binary(int start, int end, int num) {
        while (start < end){
            int mid = (start + end)/2;
            if(arr.get(mid) >= num) end = mid;
            else start = mid+1;
        }
        arr.set(end, num);
    }
}

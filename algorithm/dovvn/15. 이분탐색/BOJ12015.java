import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static List<Integer> ans; //LIS

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        ans = new ArrayList<>();
        ans.add(0); //초기에 0넣어주기

        /*LIS 만들기
         * 1. 리스트에서 가장 마지막 값보다 크면 넣어줌
         * 2. 작거나 같으면 이분탐색해서 자리 찾아주기
         * */

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > ans.get(ans.size() - 1)) ans.add(num);
            else { //num을 넣어줄 인덱스를 이분탐색
                int left = 0;
                int right = ans.size() - 1;
                int mid = 0;

                while (left < right) {
                    mid = (left + right) / 2;
                    if(ans.get(mid) >= num) right = mid; //mid앞부분에 넣어줘야 하니까
                    else left = mid + 1; //mid뒷부분에 넣어줘야 하니까
                }//End 이분탐색
                ans.set(right, num);
            }
        }//End input
        System.out.println(ans.size()-1); //맨 처음 0빼고
    }
}
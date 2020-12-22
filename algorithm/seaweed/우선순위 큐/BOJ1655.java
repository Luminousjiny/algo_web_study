package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ1655 {
    static int N, mid;
//    static PriorityQueue<Integer> pq;
//    static Queue<Integer> tmp;
    static PriorityQueue<Integer> smallHalf; // <= 중간값인 값들 저장
    static PriorityQueue<Integer> largeHalf; // > 중간값인 값들 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        /* 메모리 초과 */
/*        pq = new PriorityQueue<>(Comparator.reverseOrder()); // 짝수개일 때 더 작은값 선택하기 위해 내림차순 정렬
        tmp = new LinkedList<>();

        for (int i = 0; i < N; ++i) {
            pq.add(Integer.parseInt(br.readLine())); // pq에 값 삽입
            
            // 절반 임시 저장
            int size = pq.size();
            for (int j = 0; j < size / 2; ++j) {
                tmp.add(pq.poll());
            }

            // 중간값 출력
            mid = pq.poll();
            sb.append(mid).append("\n");

            // 뺐던 값들 다시 우선순위 큐에 넣음
            pq.add(mid);
            while (!tmp.isEmpty()) {
                pq.add(tmp.poll());
            }
        }*/

        smallHalf = new PriorityQueue<>(Comparator.reverseOrder());
        largeHalf = new PriorityQueue<>();

        for (int i = 0; i < N; ++i) {
            int curr = Integer.parseInt(br.readLine());
            if(smallHalf.isEmpty())
                smallHalf.add(curr);
            else if (largeHalf.isEmpty()) {
                if (smallHalf.peek() > curr) {
                    // 현재 값이 중간값보다 작은 경우
                    smallHalf.add(curr);
                } else {
                    // 현재 값이 중간값보다 큰 경우
                    largeHalf.add(curr);
                }
            } else {
                if (smallHalf.peek() > curr) {
                    smallHalf.add(curr);
                } else {
                    largeHalf.add(curr);
                }
            }
            // 균형 맞춤 (smallHalf에 중간값 포함한 절반, largeHalf에 나머지 절반 들어가도록)
            if(smallHalf.size() > largeHalf.size() + 1)
                largeHalf.add(smallHalf.poll());
            else if (smallHalf.size() < largeHalf.size())
                smallHalf.add(largeHalf.poll());

            // 중간값 출력
            sb.append(smallHalf.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}

package day0101;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ2749 {
    static final int K = 1000000;
    static long N, cycle;
    static Map<Long, Long> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        cycle = 1;
        map = new HashMap<>();
        map.put(0L, 0L);
        map.put(1L, 1L);

        findCycle();
        System.out.println(map.get(N % cycle));
    }

    static void findCycle() {
        boolean end = false;

        long prev = map.get(0L);
        long curr = map.get(1L);
        while (!end) {
            long next = (prev + curr) % K;
            map.put(cycle + 1, next);

            prev = curr;
            curr = next;
            if(prev == 1 && curr == 0)
                end = true;
            ++cycle;
        }
    }
}

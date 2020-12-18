package day1218;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11866 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            queue.offer(i);
        System.out.print("<");
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < K - 1; j++) {
                queue.offer(queue.poll());
            }
            System.out.print(queue.poll() + ", ");
        }
        System.out.println(queue.poll() + ">");
        scanner.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] < A[j] && B[i] < B[j]) {
                    rank[i]++;
                }
            }
        }
        for (int i = 0; i < rank.length; i++) {
            System.out.print((rank[i] + 1) + " ");
        }
    }
}
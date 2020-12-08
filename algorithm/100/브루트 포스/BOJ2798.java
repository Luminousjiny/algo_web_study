import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        int answer = 0; 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[i] = temp;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (temp >= answer && temp <= m) {
                        answer = temp;
                    } else {
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
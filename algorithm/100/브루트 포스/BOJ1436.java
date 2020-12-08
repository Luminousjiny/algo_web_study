import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int index = 665;
        while (n > 0) {
            index++;
            if (String.valueOf(index).contains("666")) {
                n--;
            }
        }
        System.out.println(index);
    }
}
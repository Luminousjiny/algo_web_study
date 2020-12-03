import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] array = input.split("-"); //  55, 50+40

        int min = 0;
        for (int i = 0; i < array.length; i++) {
            String[] array2 = array[i].split("\\+");// 50, 40
            int sum = 0;
            for (int j = 0; j < array2.length; j++) {
                sum += Integer.parseInt(array2[j]);
            }
            if (i == 0) sum *= -1;
            min -= sum;
        }

        System.out.println(min);

    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int index = 0;
        int result = 0;
        while (true)
        {
            index ++ ;
            int comp =index;
            int unit = index;
            while(unit!=0)
            {
                comp+=unit %10;
                unit/=10;
            }
            if(comp == N) 
            {
                result = index;
                break;
            }
            if(index==N)
                break;
        }
        System.out.println(result);

    }
}
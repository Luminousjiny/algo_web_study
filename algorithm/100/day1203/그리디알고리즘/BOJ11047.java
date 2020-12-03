import java.util.*;
public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//종류
        int K = scanner.nextInt();//돈
        int[] moneyValues = new int[N];
        int answer = 0;
        for(int i = 0; i<N;i++)
            moneyValues[i]= scanner.nextInt();
        for(int i = N-1; 0<=i ;i--)
        {
            answer += (K/moneyValues[i]);
            K%=moneyValues[i];
        }
        System.out.println(answer);

    }
}

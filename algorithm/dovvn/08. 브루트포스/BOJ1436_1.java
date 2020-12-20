import java.util.Scanner;

//영화감독 숌
public class Main {

    static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int num = 666;
        int count=0;

        while(true){
            String s = Integer.toString(num);
            if(s.contains("666")){
                ++count;
            }
            if(count == N){
                System.out.println(num);
                break;
            }
            num++;
        } 
    }
}

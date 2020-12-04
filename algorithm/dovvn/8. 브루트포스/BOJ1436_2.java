import sun.util.resources.cldr.ta.CurrencyNames_ta;

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
            int tmp = num;
            while(tmp > 0){
                if(tmp % 1000 == 666){ //끝에서 666있는지 확인
                    count++;
                    break;
                }
                tmp /= 10;
            }

            if(count == N){
                System.out.println(num);
                break;
            }
            num++;
        }
    }
}
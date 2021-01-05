    import java.util.Scanner;
    
//곱셈
    public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            long A = sc.nextLong();
            long B = sc.nextLong(); //지수
            long C = sc.nextLong();
            System.out.println(exp(A, B, C));
        }

        private static long exp(long x, long y, long c) {

            if(y == 1) return x % c;
            long result = exp(x, y/2, c); //절반에 해당하는 제곱승을 가져와서
            result *= result;//자기자신에게 곱합 => y
            result %= c;

            if(y % 2 != 0) { //이 때, y가 홀수인 경우
                result *= x;
                result %= c;
            }

            return result;
        }
    }
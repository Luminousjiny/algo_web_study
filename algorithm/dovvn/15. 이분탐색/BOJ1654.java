    import java.util.Arrays;
    import java.util.Scanner;

    //랜선자르기
    public class Main {

        static int K,N; //이미 가지고 있는 랜선 개수, 필요한 랜선 개수
        static int[] lines; //랜선 길이 배열

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            K = sc.nextInt();
            N = sc.nextInt();

            lines = new int[K];
            for(int i=0; i<K; i++) lines[i] = sc.nextInt();//End input

            Arrays.sort(lines);

            long left = 1; //최소 랜선 길이
            long right = lines[K-1]; //최대 랜선 길이
            long mid = 0; //현재 랜선 길이

            while(left <= right){
                mid = (left + right) / 2;
                long cnt = 0; //mid로 만들 수 있는 랜선 개수

                for(int line : lines)  cnt += line / mid; //이미 가지고 있는 랜선으로 만들수 있는 랜선 개수 누적 합
                if(cnt >= N) left = mid + 1; //더 많이 만들었다면 랜선을 길게 해서 다시 시도, 만약 N개 만들어도 최대값이 존재할 수 있음
                else right = mid - 1;
            }

            System.out.println(right);
        }
    }
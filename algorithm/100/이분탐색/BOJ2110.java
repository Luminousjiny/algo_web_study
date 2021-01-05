package 이분탐색;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2110 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] array = new int [N];
        for (int i = 0; i <N ; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(array);
        
        int left = 1;
        int right = array[N-1]-array[0];// 가능한 최대거리
        int distance = 0;
        int answer = 0;

        while(left <= right){
            int mid= (left + right) /2;
            int start = array[0];
            int count =1;
            for (int i = 0; i <N ; i++) {
                distance= array[i]-start;
                if(distance >= mid){ 
                    count++;
                    start = array[i];
                }
            }

            if(count>=C){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid-1;
            }
         }
        System.out.println(answer);
    }
}
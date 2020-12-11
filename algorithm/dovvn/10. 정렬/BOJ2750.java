import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//수정렬하기
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for(int i=0; i<N; i++){
            arr[i]  = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//수정렬하기2
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);
        for(int num : arr){
            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }
}
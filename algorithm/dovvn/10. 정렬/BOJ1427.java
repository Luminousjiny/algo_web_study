import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//소트인사이드
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Integer[] nums = new Integer[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = arr[i]-'0';
        }

        Arrays.sort(nums, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Integer i : nums){
            sb.append(i);
        }
        System.out.println(sb);
    }
}
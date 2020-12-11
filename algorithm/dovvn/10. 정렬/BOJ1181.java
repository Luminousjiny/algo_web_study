import java.io.*;
import java.util.*;

//단어정렬
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(arr.contains(input)) continue;
            arr.add(input);
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                }else if (o1.length() < o2.length()) {
                    return -1;
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s).append('\n');
        }
        bw.write(sb+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
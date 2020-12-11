import java.io.*;
import java.util.*;

//통계학
public class Main{

    static int[] arr;
    static Map<Integer,Integer> map;
    static int N;
    static int maxCnt = 1; //최다 개수
    static int sum;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        map = new HashMap<>();

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            sum += input;
            maxNum = Math.max(maxNum, input);
            minNum = Math.min(minNum, input);
            if(!map.containsKey(input)) map.put(input, 1);
            else{
                maxCnt = Math.max(maxCnt, map.get(input)+1);
                map.put(input, map.get(input)+1);
            }
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(avg()+"\n");
        sb.append(center()+"\n");
        sb.append(count()+"\n");
        sb.append(dist());
        bw.write(sb+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dist() {
        return maxNum-minNum;
    }

    private static int count() {
        List<Integer> tmp = new ArrayList<>(map.keySet());
        List<Integer> freq = new ArrayList<>();

        for(int i=0; i<tmp.size(); i++){
            int key = tmp.get(i);
            if(map.get(key) == maxCnt){
                freq.add(key);
            }
        }
        Collections.sort(freq);

        if(freq.size() == 1) return freq.get(0);
        else return freq.get(1);

    }

    private static int center() {
        int num = arr.length/2;
        return arr[num];
    }

    private static int avg() {
        return Math.round((float)sum/N);
    }
}
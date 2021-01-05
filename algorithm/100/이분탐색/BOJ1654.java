package 이분탐색;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ1654 {
	static int K, N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    	K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] array = new int[K];
        long left = 1;
        long right = 0;
        for (int i = 0; i < K; i++) {
            array[i] = Integer.parseInt(br.readLine().trim());
            right = Math.max(right, array[i]);
        }
        System.out.println(binarySearch(array, left, right));
    }
    private static long binarySearch(int[] array, long left, long right) {
    	//이분탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += (array[i] / mid);
            }
            if (sum >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
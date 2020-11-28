package day1128;

public class BOJ4673 {
    /**
     * 10,000보다 작은 셀프넘버 한 줄에 하나씩 출력
     * 셀프넘버 : 생성자가 없는 숫자
     */
    static boolean[] isNotSelf; // 셀프넘버 : false, 셀프넘버 아님 : true
    static final int N = 10000;
    public static void main(String[] args) {
        isNotSelf = new boolean[N + 1];
        for(int i = 1; i <= N; i++){
            if(!isNotSelf[i])
                checkSelf(i);
        }
        for(int i = 1; i <= N; i++){
            if(!isNotSelf[i])
                System.out.println(i);
        }
    }

    static void checkSelf(int start){
        int curr = start + ((start / 1000) % 10) + ((start / 100) % 10) + ((start/10) % 10) + (start % 10);

        while(curr <= N && !isNotSelf[curr]){
            isNotSelf[curr] = true;
            curr = curr + ((curr / 1000) % 10) + ((curr / 100) % 10) + ((curr/10) % 10) + (curr % 10);
        }
    }
}

package day1201;

import java.util.ArrayList;

public class BOJ4673 {
    public static void main(String[] args) {
        int[] num = new int[10000];
        ArrayList<Integer> arr = new ArrayList<>();

        int i = 0;
        while (true) {
            i++;
            if(i>10000) break;
            num[i-1] = d(i);

            boolean chk = false;
            for (int j = 0; j < i-1; j++) {
                if (i == num[j]) {
                    chk = true;
                    break;
                }
            }
            if(!chk){
                arr.add(d(i));
            }
        }

        for (int j = 0; j < arr.size(); j++) {
            System.out.println(arr.get(j));
        }
    }
    // n 과 n의 각자리수를 더하는 함수 = d(n)
    static int d(int n){
        return n + (n/10000)+ ((n%10000)/1000)+ ((n%1000)/100) +((n%100)/10)+(n%10);
    }
}

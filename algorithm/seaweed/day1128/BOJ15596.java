package day1128;

public class BOJ15596 {
    public long sum(int[] a){
        long result = 0;

        for(int num : a){
            result += num;
        }
        return result;
    }
}

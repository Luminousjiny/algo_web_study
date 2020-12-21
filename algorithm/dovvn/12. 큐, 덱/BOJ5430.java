import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int T;
    static char[] orders; //명령어 배열
    static List<Integer> nums; //숫자 배열
    static StringBuilder Ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Ans = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            orders = br.readLine().toCharArray(); //명령어 배열
            boolean isEmpty = false, isReverse = false; //비었는지, 뒤집어야 하는지
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine()); //수의 개수
            String input = br.readLine();

            String[] tmp = input.substring(1, input.length() - 1).split(",");
            nums = new ArrayList<>(); //숫자 배열
            for(String num : tmp){
                if(!num.equals("")) nums.add(Integer.parseInt(num));
            }


            for (int i = 0; i < orders.length; i++) { //명령 진행
                if (orders[i] == 'R') {
                    isReverse = !isReverse;
                } else { //D이면
                    if (nums.size() == 0) {
                        isEmpty = true;
                        break;
                    }
                    if (isReverse) nums.remove(nums.size() - 1);
                    else nums.remove(0);
                }
            }//End 명령


            //출력하기
            if (!isEmpty) {
                sb.append("[");
                if (isReverse) for (int i = nums.size() - 1; i >= 0; i--) { //반대로 출력
                    if (i == 0) sb.append(nums.get(i));
                    else sb.append(nums.get(i) + ",");
                }
                else { //앞에서부터 출력
                    for (int i = 0; i < nums.size(); i++) {
                        if (i == nums.size() - 1) sb.append(nums.get(i));
                        else sb.append(nums.get(i) + ",");
                    }
                }
                sb.append("]");
            } else sb.append("error");

            Ans.append(sb + "\n");
        }//End tc

        bw.write(Ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
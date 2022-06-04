import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheGreatestNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 34, 30, 5, 9}; // 9 5 34 3 30
        System.out.println(solution(numbers));
    }

    /**
     * String 아스키 코드 값을 사용하여 문자로 비교한 풀이
     * */
    public static String solution(int[] numbers) {
        String[] strs = new String[numbers.length];

        // 숫자의 아스키 코드 값의 크기로 비교하려면 string으로 변환
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }

        // 앞자리가 같은 숫자의 경우 비교 처리
        Arrays.sort(strs, ((o1, o2) -> ((o2 + o1).compareTo(o1 + o2))));

        // StringBuilder를 사용하여 속도 개선
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        String answer = sb.toString();

        // 0이 여러 개 있을 경우 1개만 출력
        return answer.charAt(0) == '0' ? "0" : answer;
    }

    /**
     * List를 사용하여 숫자로 비교한 풀이
     * */
    public static String solution2(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        // 각 숫자를 String으로 변환하여 붙여서 숫자로 비교 & 내림차순 정렬
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}

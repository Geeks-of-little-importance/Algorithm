public class XGapNumber {

    public static void main(String[] args) {
        long[] answer = solution(-4, 2);

        for (long val : answer) {
            System.out.println(val);
        }
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        int index = 0;
        long value = 0;
        while (index < n) {
            answer[index] = (value += x);
            index++;
        }

        return answer;
    }

    public static long[] solution1(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;

    }
}

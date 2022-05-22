public class CalculatingMissingAmount {

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count) {
        int totalCount = 0;
        for (int i = 1; i <= count; i++) {
            totalCount += i;
        }

        long answer = (long) price * totalCount - money;
        return answer > 0 ? answer : 0;
    }
}

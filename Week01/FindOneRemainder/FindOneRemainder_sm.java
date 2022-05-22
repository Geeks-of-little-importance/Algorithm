public class FindOneRemainder {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static int solution(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return -1;
    }
}

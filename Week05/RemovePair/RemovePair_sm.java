import java.util.Stack;

public class RemovePair {

    public static void main(String[] args) {
        String s = "cdcd";
        System.out.println(solution(s)); // 0
    }

    public static int solution(String s) {
        Stack<Character> bucket = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!bucket.empty() && bucket.peek() == c) {
                bucket.pop();
            } else {
                bucket.push(c);
            }
        }
        return bucket.empty() ? 1 : 0;
    }
}

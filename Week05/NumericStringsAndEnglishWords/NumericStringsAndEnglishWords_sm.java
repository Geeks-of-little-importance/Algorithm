public class NumericStringsAndEnglishWords {

    /**
     * String에 특정 문자가 포함되어 있는지 확인 : contains() -> replace()
     * replace()를 써도 모든 문자열이 치환됨.
     * replaceAll()은 정규식을 사용할 때 사용!
     * */
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s)); // 1478
    }

    public static int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < numbers.length; i++) {
            if (s.contains(numbers[i])) {
                s = s.replace(numbers[i], String.valueOf(i));
            }
        }
        return Integer.parseInt(s);
    }
}

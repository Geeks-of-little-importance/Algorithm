import java.util.Arrays;

public class PlusNotExistNumber {

    public static void main(String[] args) {
//        int[] numbers = new int[]{1,2,3,4,6,7,8,0};
        int[] numbers = new int[]{5,8,4,0,6,7,9};

        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 45; // 0 ~ 9 더하기
        Arrays.sort(numbers);

        int startNum = 0;
        int numbersIndex = 0;
        while (numbersIndex < numbers.length) {
            if (startNum < numbers[numbersIndex]) {
                startNum++;
            } else if (startNum == numbers[numbersIndex]) {
                answer -= startNum;
                startNum++;
                numbersIndex++;
            } else { // startNum > numberIndex
                numbersIndex++;
            }
        }

        return answer;
    }
}

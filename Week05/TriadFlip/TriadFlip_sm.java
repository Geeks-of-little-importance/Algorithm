public class TriadFlip {

    public static void main(String[] args) {
        int n = 125;
        System.out.println(solution(n)); // 229
    }

    public static int solution(int n) {
        String temp = "";
        int answer = 0;

        while (n > 0) {
            temp = n % 3 + temp; // 뒤집지 않은 3진수 그대로 구함
            n /= 3;
        }

        char[] charArr = temp.toCharArray();
        for (int i = 0; i < charArr.length; i++) { // 3의 지수를 0부터 올려가면서 곱함
            answer += Integer.parseInt(String.valueOf(charArr[i])) * Math.pow(3, i);
        }

        return answer;
    }

    public static int solution1(int n) {
        String answer = "";

        while (n > 0){
            answer += n % 3; // 뒤집어진 3진수 구함
            n /= 3;
        }

/**
        Integer.toBinaryString(); // 10진수 -> 2진수 변환
        Integer.toHexString(); // 10진수 -> 16진수 변환
        Integer.toOctalString(); // 10진수 -> 8진수 변환
        Integer.parseInt(문자열, 진법); // 주어진 진법의 숫자를 10진수로 변환해줌
*/
        return Integer.parseInt(answer, 3); // 3진수 -> 10진수 변환
    }
}

public class SecretMap {

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};

        String[] answer = solution(n ,arr1, arr2);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n ; i++) {
            answer[i] = convertToBinaryMap(n, arr1[i], arr2[i]);
        }
        return answer;
    }

    public static String convertToBinaryMap(int n, int a, int b) {
        String result = "";
        String array = Integer.toBinaryString(a | b);
        while (array.length() < n) {
            array = "0" + array;
        }
        for (char c : array.toCharArray()) {
            result += (c == '0') ? " " : "#";
        }
        return result;
    }
}

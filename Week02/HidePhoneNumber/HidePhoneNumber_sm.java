public class HidePhoneNumber {

    public static void main(String[] args) {
        System.out.println(solution("01012345678"));
    }

    public static String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }
        answer += phone_number.substring(phone_number.length() - 4, phone_number.length());
        return answer;
    }

    public static String solution1(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}

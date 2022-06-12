import java.util.Arrays;

public class IncompleteRunner {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion)); // 4
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 비교하다가 다른 사람이 나오면, 참가자 쪽에서 없는거기 때문에 참가자 return
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        // 완주하지 못한 참가자가 맨 끝에 정렬되었을 경우 return되지 않았을테니 끝 return
        return participant[participant.length - 1];
    }

}

import java.util.*;

public class ReportResultReceive {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] answer = solution(id_list, report, k);
        for (int item : answer) {
            System.out.print(item + " ");
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 신고당한 횟수 count map
        Map<String, Integer> reportedCountMap = new HashMap<>(id_list.length);
        // 처리 결과 메일 횟수 count map
        Map<String, Integer> receivedCountMap = new LinkedHashMap<>(id_list.length);

        // initialize
        for (String id : id_list) {
            reportedCountMap.put(id, k);
            receivedCountMap.put(id, 0);
        }

        // 집합에 담아서 중복 신고 경우의 수 처리
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        Iterator<String> iterator = reportSet.iterator();
        while (iterator.hasNext()) {
            String badUser = iterator.next().split(" ")[1];
            reportedCountMap.put(badUser, reportedCountMap.get(badUser) - 1);
        }

        // 정지될 유저 set 만들기
        Set<String> suspendedUserSet = new HashSet<>();
        for (String badUser : reportedCountMap.keySet()) {
            if (reportedCountMap.get(badUser) <= 0) {
                suspendedUserSet.add(badUser);
            }
        }

        // 정지된 유저를 신고한 사람에게 갈 메일 count 처리
        iterator = reportSet.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            String receiver = item.split(" ")[0];
            String badUser = item.split(" ")[1];

            if (suspendedUserSet.contains(badUser)) {
                receivedCountMap.put(receiver, receivedCountMap.get(receiver) + 1);
            }
        }

        // answer에 담아주기
        int idx = 0;
        for (String receiver : receivedCountMap.keySet()) {
            answer[idx++] = receivedCountMap.get(receiver);
        }

        return answer;
    }
}

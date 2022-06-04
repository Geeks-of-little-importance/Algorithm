import java.util.*;

public class FailureRate {

    public static void main(String[] args) {
        int N = 8;
        int[] stages = {1,2,3,4,5,6,7}; // 1 2 2 2 3 3 4 6 // length 7

        int[] answer = solution(N, stages);
        for (int item : answer) {
            System.out.print(item + " ");
        }
    }

    static class Rate {
        int idx;
        double rate;

        public Rate(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Rate> rateList = new ArrayList<>(N);

        Arrays.sort(stages);

        int arrIdx = 0; // stages array의 index
        int stageIdx = 1; // 현재 실패율을 계산할 stage의 index

        // arrIdx와 stageIdx가 범위 내에 있을 동안 반복
        while (arrIdx < stages.length && stageIdx <= N) {
            // stages.length - stagesIdx <- 도달한 사람의 수
            int reachedCount = stages.length - arrIdx;
            // 현재 도전중인 사람의 수
            int challengingCount = 0;

            // arrIdx가 범위 내에 있고, 해당 스테이지에 머무르는 사람이 있다면
            while (arrIdx < stages.length && stages[arrIdx] == stageIdx) {
                challengingCount++; // 머무르는 사람의 수 증가
                arrIdx++;
            }

            if (challengingCount == 0) {
                rateList.add(new Rate(stageIdx, 0.0));
            } else {
                rateList.add(new Rate(stageIdx, (double) challengingCount / reachedCount));
            }
            // 다음 스테이지로 이동
            stageIdx++;
        }

        // 실패율을 기준으로 내림차순 sorting
        Collections.sort(rateList, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));
        for (int i = 0; i < N; i++) {
            // 아무도 도달하지 못한 stage 처리
            answer[i] = (i < rateList.size()) ? rateList.get(i).idx : i + 1;
        }

        return answer;
    }

}

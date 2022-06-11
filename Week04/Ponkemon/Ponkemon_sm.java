import java.util.HashSet;
import java.util.Set;

public class PonkeMon {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2}; // 2
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        // 중복되지 않은 조합을 골라야 하므로 Set에 넣기
        Set<Integer> set = new HashSet<>();
        for (int item : nums) {
            set.add(item);
        }
        // 중복되지 않은 조합들이 많을 수록 좋지만, N/2는 넘지 않아야 하므로 둘 중 작은 값 return
        return Math.min(set.size(), nums.length / 2);
    }
}

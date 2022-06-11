import java.util.Stack;

public class CraneMachineGame {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves)); // 4
    }

    /**
     * 이번 풀이
     * */
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int endPoint = board[0].length; // craneLength의 제한 <- ** 필수 **

        Stack<Integer> bucket = new Stack<>();

        for (int move : moves) {
            int craneLength = 0; // row 인덱스 - 크레인이 뻗어갈 깊이
            // 더 이상 뻗을 곳이 없을 동안 반복
            while (craneLength < endPoint) {
                int doll = board[craneLength][move - 1];

                // 인형이 없으면 craneLength만 늘리고 패스
                if (doll == 0) {
                    craneLength++;
                    continue;
                }

                // 바구니 맨 위 인형과 뽑은 인형이 일치하면
                if (!bucket.empty() && bucket.peek().equals(doll)) {
                    // 바구니에서 꺼내고, 인형 2개를 count 해줌
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
                // 바구니에 push하거나 pop했으므로 해당 크레인이 뽑은 곳에 인형이 비었음을 표시해줌
                // 해당 move에는 처리가 끝났으니 break로 빠져나옴
                // ** 이거 깜빡해서 한참 헤맸음 **
                board[craneLength][move - 1] = 0;
                break;
            }
        }
        return answer;
    }

    /**
    * 이전 나의 풀이
    * */
    public static int solution2(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) { // 크레인이 움직인 곳
            for (int row = 0; row < N; row++) { // board row 훑기
                int item = board[row][move - 1];

                if (item == 0) continue;

                if (!stack.isEmpty() && stack.peek() == item) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(item);
                }
                board[row][move - 1] = 0;
                break;
            }
        }

        return answer;
    }
}

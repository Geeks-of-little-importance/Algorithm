public class PressingKeypad {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 5, 5}; // 순서대로 누를 번호가 담긴 배열
        String hand = "right"; // 왼손잡이(left) or 오른손잡이(right)
        System.out.println(solution(numbers, hand)); // LRLLLRLLRRL
    }

    /**
     * 좌표 값을 기준으로 거리를 구한 직관적인 풀이
     * */
    public static String solution(int[] numbers, String hand) {
        int[][] keypad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -2}}; // row : 0 ~ 2, col : 0 ~ 3
        StringBuilder sb = new StringBuilder();

        /** 현재 손가락의 위치 */
        int leftFinger = -1; // *을 대체하는 임의의 값
        int rightFinger = -2; // #을 대체하는 임의의 값
        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]) {
                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    leftFinger = numbers[i];
                    break;
                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    rightFinger = numbers[i];
                    break;
                case 2:
                case 5:
                case 8:
                case 0:
                    String closerFinger = getCloserFinger(keypad, leftFinger, rightFinger, numbers[i], hand);
                    sb.append(closerFinger);
                    if (closerFinger.equals("L")) {
                        leftFinger = numbers[i];
                    } else { // "R"
                        rightFinger = numbers[i];
                    }
            }
        }
        return sb.toString();
    }

    public static String getCloserFinger(int[][] keypad, int pivotL, int pivotR, int clickNum, String hand) {
        int distL = getDistance(keypad, pivotL, clickNum);
        int distR = getDistance(keypad, pivotR, clickNum);
        if (distL < distR) {
            return "L";
        } else if (distR < distL) {
            return "R";
        } else { // distR == distL
            return hand.equals("left") ? "L" : "R";
        }
    }

    public static int getDistance(int[][] keypad, int a, int b) {
        int aX = 0, aY = 0;
        int bX = 0, bY = 0;
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                if (keypad[i][j] == a) {
                    aX = i; aY = j;
                } // <- 여기서 else를 쓰면 안됨..! 연속으로 같은 번호를 누를 수도 있으니
                if (keypad[i][j] == b) {
                    bX = i; bY = j;
                }
            }
        }
        // 맨해튼 거리 구하기 (유클리드 거리 X)
        return Math.abs((aX - bX)) + Math.abs((aY - bY));
    }

    /**
     * 숫자 자체를 가지고 규칙을 찾아 계산식으로 풀이한 방법
     * */
    public static String solution1(int[] numbers, String hand) {
        String answer = "";

        int curL = 10;
        int curR = 12;
        for (int number : numbers) {
            number = (number == 0) ? 11 : number;
            switch(number % 3) {
                case 0:
                    answer += "R";
                    curR = number;
                    break;
                case 1:
                    answer += "L";
                    curL = number;
                    break;
                case 2:
                    int L = Math.abs(curL - number) / 3 + Math.abs(curL - number) % 3;
                    int R = Math.abs(curR - number) / 3 + Math.abs(curR - number) % 3;

                    if (L == R) {
                        if (hand.equals("left")) {
                            answer += "L";
                            curL = number;
                        } else {
                            answer += "R";
                            curR = number;
                        }
                    } else if (L < R) {
                        answer += "L";
                        curL = number;
                    } else {
                        answer += "R";
                        curR = number;
                    }
                    break;
            }
        }

        return answer;
    }
}

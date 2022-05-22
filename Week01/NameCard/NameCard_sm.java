public class NameCard {

    public static void main(String[] args) {
        int[][] sizes = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) { // 왼쪽에 큰거 정렬
                swap(sizes[i], 0 , 1);
            }
        }

        int rowMax = Integer.MIN_VALUE;
        int colMax = Integer.MIN_VALUE;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > rowMax) {
                rowMax = sizes[i][0];
            }
            if (sizes[i][1] > colMax) {
                colMax = sizes[i][1];
            }
        }

        return colMax * rowMax;
    }

    public static void swap(int[] item, int i, int j) {
        int temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }
}

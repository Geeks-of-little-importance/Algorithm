import java.util.Scanner;

public class RectangleStar {

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

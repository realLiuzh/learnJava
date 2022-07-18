import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("all")
public class Solution2 {
    private static int n;
    private static int m;
    private static int x;
    private static int y;

    private static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        dp = new int[n + 1][m + 1];
//        Arrays.fill(dp[0], -2);
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n * m);
        }
//        for (int i = 0; i < dp[0].length; i++) {
//            dp[i][0] = -2;
//        }

        dp[x][y] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j - 1 >= 0)
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j - 1] + 1);
                if (j + 3 < dp[0].length)
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j + 3] + 1);
                if (i + 2 < dp.length && j - 1 >= 0)
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i + 2][j - 1] + 1);
                if (i + 2 < dp.length && j + 3 < dp[0].length)
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i + 2][j + 3] + 1);

                if (i - 1 >= 0)
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i - 1][j] + 1);
                if (i + 3 < dp.length)
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i + 3][j] + 1);
                if (i - 1 >= 0 && j + 2 < dp[0].length)
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i - 1][j + 2] + 1);
                if (i + 3 < dp.length && j + 2 < dp[0].length)
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i + 3][j + 2] + 1);
            }
        }

        System.out.println();


    }
}

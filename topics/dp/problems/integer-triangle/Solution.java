package topics.dp.problems.integer_triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] triangle = readTriangle(reader);

        Solution solution = new Solution();
        int result = solution.solve(triangle);
        System.out.println(result);
    }

    int solve(int[][] triangle) {
        int rowCount = triangle.length;

        if (rowCount == 0) {
            return 0;
        }

        // dp[row][column] = 해당 칸에 도착했을 때 만들 수 있는 최대 합
        int[][] dp = new int[rowCount][];

        for (int row = 0; row < rowCount; row++) {
            dp[row] = new int[row + 1];
        }

        // 첫 칸은 시작점이므로 자기 자신이 최대 합이다.
        dp[0][0] = triangle[0][0];

        for (int row = 1; row < rowCount; row++) {
            // 가장 왼쪽 칸은 바로 위 왼쪽 가장자리에서만 내려올 수 있다.
            dp[row][0] = dp[row - 1][0] + triangle[row][0];

            // 가장 오른쪽 칸도 바로 위 오른쪽 가장자리에서만 내려올 수 있다.
            dp[row][row] = dp[row - 1][row - 1] + triangle[row][row];

            for (int column = 1; column < row; column++) {
                // 가운데 칸은 왼쪽 위와 오른쪽 위 부모 중 큰 값을 선택한다.
                int leftParent = dp[row - 1][column - 1];
                int rightParent = dp[row - 1][column];
                dp[row][column] = Math.max(leftParent, rightParent) + triangle[row][column];
            }
        }

        // 마지막 줄 어디에서 끝나든 되므로, 마지막 줄의 최대값이 정답이다.
        int maxSum = 0;

        for (int value : dp[rowCount - 1]) {
            maxSum = Math.max(maxSum, value);
        }

        return maxSum;
    }

    String solveFromInput(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(input));
        int[][] triangle = readTriangle(reader);
        return Integer.toString(solve(triangle));
    }

    private static int[][] readTriangle(BufferedReader reader) throws IOException {
        int rowCount = Integer.parseInt(reader.readLine().trim());
        int[][] triangle = new int[rowCount][];

        for (int row = 0; row < rowCount; row++) {
            triangle[row] = new int[row + 1];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            for (int column = 0; column <= row; column++) {
                triangle[row][column] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        return triangle;
    }
}

package topics.dp.problems.rgb_distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] costs = readCosts(reader);

        Solution solution = new Solution();
        int result = solution.solve(costs);
        System.out.println(result);
    }

    int solve(int[][] costs) {
        int houseCount = costs.length;

        if (houseCount == 0) {
            return 0;
        }

        // dp[i][color] = i번째 집까지 칠했을 때, i번째 집 색이 color인 최소 비용
        int[][] dp = new int[houseCount][3];

        // 첫 집은 이전 집이 없으므로 각 색 비용을 그대로 시작값으로 사용한다.
        dp[0][RED] = costs[0][RED];
        dp[0][GREEN] = costs[0][GREEN];
        dp[0][BLUE] = costs[0][BLUE];

        for (int house = 1; house < houseCount; house++) {
            // 현재 집을 빨강으로 칠하면 이전 집은 초록 또는 파랑이어야 한다.
            dp[house][RED] = Math.min(dp[house - 1][GREEN], dp[house - 1][BLUE]) + costs[house][RED];
            dp[house][GREEN] = Math.min(dp[house - 1][RED], dp[house - 1][BLUE]) + costs[house][GREEN];
            dp[house][BLUE] = Math.min(dp[house - 1][RED], dp[house - 1][GREEN]) + costs[house][BLUE];
        }

        // 마지막 집의 색은 정해져 있지 않으므로, 세 색 중 최소 비용이 정답이다.
        return Math.min(dp[houseCount - 1][RED], Math.min(dp[houseCount - 1][GREEN], dp[houseCount - 1][BLUE]));
    }

    String solveFromInput(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(input));
        int[][] costs = readCosts(reader);
        return Integer.toString(solve(costs));
    }

    private static int[][] readCosts(BufferedReader reader) throws IOException {
        int houseCount = Integer.parseInt(reader.readLine().trim());
        int[][] costs = new int[houseCount][3];

        for (int house = 0; house < houseCount; house++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            costs[house][RED] = Integer.parseInt(tokenizer.nextToken());
            costs[house][GREEN] = Integer.parseInt(tokenizer.nextToken());
            costs[house][BLUE] = Integer.parseInt(tokenizer.nextToken());
        }

        return costs;
    }
}

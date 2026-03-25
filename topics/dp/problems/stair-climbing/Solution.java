package topics.dp.problems.stair_climbing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int stairCount = Integer.parseInt(reader.readLine().trim());
        int[] stairScores = new int[stairCount];

        for (int index = 0; index < stairCount; index++) {
            stairScores[index] = Integer.parseInt(reader.readLine().trim());
        }

        Solution solution = new Solution();
        int result = solution.solve(stairScores);
        System.out.println(result);
    }

    int solve(int[] stairScores) {
        int stairCount = stairScores.length;

        if (stairCount == 0) {
            return 0;
        }

        // 작은 입력은 점화식을 돌리기보다 바로 답을 정하는 편이 더 명확하다.
        if (stairCount == 1) {
            return stairScores[0];
        }

        if (stairCount == 2) {
            return stairScores[0] + stairScores[1];
        }

        // dp[i] = i번째 계단을 반드시 밟고 도착했을 때의 최대 점수
        int[] dp = new int[stairCount];
        dp[0] = stairScores[0];
        dp[1] = stairScores[0] + stairScores[1];
        // 세 계단을 모두 밟을 수 없으므로, 0->2 또는 1->2 두 경우만 가능하다.
        dp[2] = Math.max(stairScores[0] + stairScores[2], stairScores[1] + stairScores[2]);

        for (int index = 3; index < stairCount; index++) {
            // i번째 계단은 i-2에서 바로 오거나, i-3에서 i-1을 거쳐 올 수 있다.
            int skipPrevious = dp[index - 2] + stairScores[index];
            int takePrevious = dp[index - 3] + stairScores[index - 1] + stairScores[index];
            dp[index] = Math.max(skipPrevious, takePrevious);
        }

        // dp의 정의상 마지막 계단을 반드시 밟고 도착한 최대 점수가 이미 저장되어 있다.
        return dp[stairCount - 1];
    }

    String solveFromInput(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.StringReader(input));
        int stairCount = Integer.parseInt(reader.readLine().trim());
        int[] stairScores = new int[stairCount];

        for (int index = 0; index < stairCount; index++) {
            stairScores[index] = Integer.parseInt(reader.readLine().trim());
        }

        return Integer.toString(solve(stairScores));
    }
}

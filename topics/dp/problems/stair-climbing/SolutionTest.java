package topics.dp.problems.stair_climbing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void sampleCase() {
        int[] stairScores = {10, 20, 15, 25, 10, 20};

        assertEquals(75, solution.solve(stairScores));
    }

    @Test
    void limitCase() {
        int[] stairScores = new int[300];

        for (int index = 0; index < stairScores.length; index++) {
            stairScores[index] = 10_000;
        }

        assertEquals(2_000_000, solution.solve(stairScores));
    }

    @Test
    void trapCase() {
        int[] stairScores = {10, 20, 15};

        assertEquals(35, solution.solve(stairScores));
    }

    @Test
    void ioSampleCase() throws Exception {
        String input = """
                6
                10
                20
                15
                25
                10
                20
                """;

        assertEquals("75", solution.solveFromInput(input));
    }
}

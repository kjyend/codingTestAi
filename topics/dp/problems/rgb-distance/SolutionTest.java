package topics.dp.problems.rgb_distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void sampleCase() {
        int[][] costs = {
                {26, 40, 83},
                {49, 60, 57},
                {13, 89, 99}
        };

        assertEquals(96, solution.solve(costs));
    }

    @Test
    void limitCase() {
        int[][] costs = new int[1000][3];

        for (int house = 0; house < costs.length; house++) {
            costs[house][0] = 1_000;
            costs[house][1] = 1_000;
            costs[house][2] = 1_000;
        }

        assertEquals(1_000_000, solution.solve(costs));
    }

    @Test
    void trapCase() {
        int[][] costs = {
                {1, 100, 100},
                {100, 100, 100},
                {1, 100, 100}
        };

        assertEquals(102, solution.solve(costs));
    }

    @Test
    void ioSampleCase() throws Exception {
        String input = """
                3
                26 40 83
                49 60 57
                13 89 99
                """;

        assertEquals("96", solution.solveFromInput(input));
    }
}

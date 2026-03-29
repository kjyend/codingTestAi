package topics.dp.problems.integer_triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void sampleCase() {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        assertEquals(30, solution.solve(triangle));
    }

    @Test
    void limitCase() {
        int rowCount = 500;
        int[][] triangle = new int[rowCount][];

        for (int row = 0; row < rowCount; row++) {
            triangle[row] = new int[row + 1];

            for (int column = 0; column <= row; column++) {
                triangle[row][column] = 9_999;
            }
        }

        assertEquals(4_999_500, solution.solve(triangle));
    }

    @Test
    void trapCase() {
        int[][] triangle = {
                {5},
                {9, 1},
                {1, 1, 100},
                {1, 1, 1, 100}
        };

        assertEquals(206, solution.solve(triangle));
    }

    @Test
    void ioSampleCase() throws Exception {
        String input = """
                5
                7
                3 8
                8 1 0
                2 7 4 4
                4 5 2 6 5
                """;

        assertEquals("30", solution.solveFromInput(input));
    }
}

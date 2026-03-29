package topics.graph.problems.traversal.maze_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void sampleCase() {
        char[][] maze = {
                {'1', '0', '1', '1', '1', '1'},
                {'1', '0', '1', '0', '1', '0'},
                {'1', '0', '1', '0', '1', '1'},
                {'1', '1', '1', '0', '1', '1'}
        };

        assertEquals(15, solution.solve(maze));
    }

    @Test
    void limitCase() {
        int rowCount = 100;
        int columnCount = 100;
        char[][] maze = new char[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                maze[row][column] = '1';
            }
        }

        assertEquals(199, solution.solve(maze));
    }

    @Test
    void trapCase() {
        char[][] maze = {
                {'1', '1', '1'},
                {'0', '0', '1'},
                {'1', '1', '1'}
        };

        assertEquals(5, solution.solve(maze));
    }

    @Test
    void ioSampleCase() throws Exception {
        String input = """
                4 6
                101111
                101010
                101011
                111011
                """;

        assertEquals("15", solution.solveFromInput(input));
    }
}

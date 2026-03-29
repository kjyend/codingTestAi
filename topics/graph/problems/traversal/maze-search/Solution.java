package topics.graph.problems.traversal.maze_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COLUMN_DIRECTIONS = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[][] maze = readMaze(reader);

        Solution solution = new Solution();
        int result = solution.solve(maze);
        System.out.println(result);
    }

    int solve(char[][] maze) {
        int rowCount = maze.length;
        int columnCount = maze[0].length;

        boolean[][] visited = new boolean[rowCount][columnCount];
        // distance[row][column] = 시작점에서 해당 칸까지의 최소 칸 수
        int[][] distance = new int[rowCount][columnCount];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        // 시작 칸도 지나간 칸 수에 포함되므로 거리를 1로 시작한다.
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentColumn = current[1];

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = currentRow + ROW_DIRECTIONS[direction];
                int nextColumn = currentColumn + COLUMN_DIRECTIONS[direction];

                if (!isValidPosition(nextRow, nextColumn, rowCount, columnCount)) {
                    continue;
                }

                // 범위 밖, 벽, 이미 방문한 칸은 다음 탐색 후보에서 제외한다.
                if (maze[nextRow][nextColumn] == '0' || visited[nextRow][nextColumn]) {
                    continue;
                }

                // 가중치가 없으므로, 처음 도착한 거리가 곧 최단 거리다.
                visited[nextRow][nextColumn] = true;
                distance[nextRow][nextColumn] = distance[currentRow][currentColumn] + 1;
                queue.offer(new int[]{nextRow, nextColumn});
            }
        }

        return distance[rowCount - 1][columnCount - 1];
    }

    String solveFromInput(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(input));
        char[][] maze = readMaze(reader);
        return Integer.toString(solve(maze));
    }

    private static char[][] readMaze(BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int rowCount = Integer.parseInt(tokenizer.nextToken());
        int columnCount = Integer.parseInt(tokenizer.nextToken());
        char[][] maze = new char[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            maze[row] = reader.readLine().trim().toCharArray();
        }

        return maze;
    }

    private boolean isValidPosition(int row, int column, int rowCount, int columnCount) {
        return row >= 0 && row < rowCount && column >= 0 && column < columnCount;
    }
}

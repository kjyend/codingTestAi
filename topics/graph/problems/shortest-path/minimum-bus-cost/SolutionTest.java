package topics.graph.problems.shortest_path.minimum_bus_cost;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void sampleCase() {
        int cityCount = 5;
        List<Solution.Edge>[] graph = buildEmptyGraph(cityCount);

        graph[1].add(new Solution.Edge(2, 2));
        graph[1].add(new Solution.Edge(3, 3));
        graph[1].add(new Solution.Edge(4, 1));
        graph[1].add(new Solution.Edge(5, 10));
        graph[2].add(new Solution.Edge(4, 2));
        graph[3].add(new Solution.Edge(4, 1));
        graph[3].add(new Solution.Edge(5, 1));
        graph[4].add(new Solution.Edge(5, 3));

        assertEquals(4, solution.solve(cityCount, graph, 1, 5));
    }

    @Test
    void ioSampleCase() throws Exception {
        String input = """
                5
                8
                1 2 2
                1 3 3
                1 4 1
                1 5 10
                2 4 2
                3 4 1
                3 5 1
                4 5 3
                1 5
                """;

        assertEquals("4", solution.solveFromInput(input));
    }

    @Test
    void limitCase() {
        int cityCount = 1000;
        List<Solution.Edge>[] graph = buildEmptyGraph(cityCount);

        for (int city = 1; city < cityCount; city++) {
            graph[city].add(new Solution.Edge(city + 1, 0));
        }

        assertEquals(0, solution.solve(cityCount, graph, 1, cityCount));
    }

    @Test
    void trapCase() {
        int cityCount = 4;
        List<Solution.Edge>[] graph = buildEmptyGraph(cityCount);

        graph[1].add(new Solution.Edge(4, 10));
        graph[1].add(new Solution.Edge(2, 1));
        graph[2].add(new Solution.Edge(3, 1));
        graph[3].add(new Solution.Edge(4, 1));
        graph[1].add(new Solution.Edge(3, 100));

        assertEquals(3, solution.solve(cityCount, graph, 1, 4));
    }

    @SuppressWarnings("unchecked")
    private List<Solution.Edge>[] buildEmptyGraph(int cityCount) {
        List<Solution.Edge>[] graph = new ArrayList[cityCount + 1];

        for (int city = 1; city <= cityCount; city++) {
            graph[city] = new ArrayList<>();
        }

        return graph;
    }
}

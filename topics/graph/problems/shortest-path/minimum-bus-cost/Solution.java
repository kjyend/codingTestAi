package topics.graph.problems.shortest_path.minimum_bus_cost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ProblemInput input = readInput(reader);

        Solution solution = new Solution();
        int result = solution.solve(input.cityCount, input.graph, input.startCity, input.endCity);
        System.out.println(result);
    }

    int solve(int cityCount, List<Edge>[] graph, int startCity, int endCity) {
        // distances[city] = 시작 도시에서 city까지의 최소 비용
        int[] distances = new int[cityCount + 1];
        Arrays.fill(distances, INF);

        // 가중치가 있는 단일 시작점 최단거리이므로 우선순위 큐 기반 다익스트라를 사용한다.
        PriorityQueue<State> priorityQueue = new PriorityQueue<>();
        distances[startCity] = 0;
        priorityQueue.offer(new State(startCity, 0));

        while (!priorityQueue.isEmpty()) {
            State current = priorityQueue.poll();

            // 우선순위 큐에는 오래된 상태도 남을 수 있으므로, 더 비싼 상태는 건너뛴다.
            if (current.cost > distances[current.city]) {
                continue;
            }

            for (Edge edge : graph[current.city]) {
                // 현재 도시를 거쳐 가는 비용이 더 싸면 최소 비용을 갱신한다.
                int nextCost = current.cost + edge.cost;

                if (nextCost < distances[edge.toCity]) {
                    distances[edge.toCity] = nextCost;
                    priorityQueue.offer(new State(edge.toCity, nextCost));
                }
            }
        }

        return distances[endCity];
    }

    String solveFromInput(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(input));
        ProblemInput problemInput = readInput(reader);
        return Integer.toString(solve(problemInput.cityCount, problemInput.graph, problemInput.startCity, problemInput.endCity));
    }

    private static ProblemInput readInput(BufferedReader reader) throws IOException {
        int cityCount = Integer.parseInt(reader.readLine().trim());
        int busCount = Integer.parseInt(reader.readLine().trim());
        List<Edge>[] graph = new ArrayList[cityCount + 1];

        for (int city = 1; city <= cityCount; city++) {
            graph[city] = new ArrayList<>();
        }

        for (int index = 0; index < busCount; index++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int fromCity = Integer.parseInt(tokenizer.nextToken());
            int toCity = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());
            graph[fromCity].add(new Edge(toCity, cost));
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int startCity = Integer.parseInt(tokenizer.nextToken());
        int endCity = Integer.parseInt(tokenizer.nextToken());

        return new ProblemInput(cityCount, graph, startCity, endCity);
    }

    private static class ProblemInput {
        private final int cityCount;
        private final List<Edge>[] graph;
        private final int startCity;
        private final int endCity;

        private ProblemInput(int cityCount, List<Edge>[] graph, int startCity, int endCity) {
            this.cityCount = cityCount;
            this.graph = graph;
            this.startCity = startCity;
            this.endCity = endCity;
        }
    }

    static class Edge {
        private final int toCity;
        private final int cost;

        Edge(int toCity, int cost) {
            this.toCity = toCity;
            this.cost = cost;
        }
    }

    private static class State implements Comparable<State> {
        private final int city;
        private final int cost;

        private State(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(State other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}

# Graph Common Patterns

이 문서는 코딩테스트에서 자주 나오는 graph 패턴을 간단히 정리한 문서다.

## 1. Connected Components

- 연결 요소 개수 세기
- 방문 배열이 핵심
- category: `traversal`

## 2. Grid BFS / DFS

- 격자 각 칸을 정점으로 본다
- 상하좌우 이동이 간선 역할을 한다
- category: `traversal`

## 3. Shortest Path

- 가중치 없음 -> BFS 후보
- 가중치 있음 -> 다익스트라 후보
- 음수 간선이 있으면 벨만포드 후보
- 모든 정점 쌍 최단거리면 플로이드 워셜 후보
- category: `shortest-path`

## 4. State Space Search

- 위치나 숫자 상태를 정점으로 본다
- 연산이 간선 역할을 한다
- category: `traversal` 또는 `shortest-path`

## 5. Topological Ordering

- 선행 조건이 있는 경우
- category: `topological-sort`

## 6. Minimum Spanning Tree

- 전체를 최소 비용으로 연결하는 경우
- 크루스칼, 프림이 대표 알고리즘
- category: `minimum-spanning-tree`

## 7. Connectivity With Union-Find

- 연결 여부를 빠르게 판단
- 간선 추가에 따라 집합을 합침
- category: `connectivity`

## Final Reminder

패턴을 외우는 것이 아니라, 문제를 보고 어떤 모델로 바꾸는지가 더 중요하다.

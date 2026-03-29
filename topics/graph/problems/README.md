# Graph Problems

이 폴더에는 graph로 분류한 실제 문제들을 넣는다.

문제는 아래 기준을 우선 따른다.

- 그래프 모델링이 분명한 문제
- BFS / DFS / 최단거리 판단 연습이 되는 문제
- 너무 쉬운 방문 체크 수준만 반복하지 않는 문제
- 중하 ~ 중상 난이도에서 학습 효과가 좋은 문제

graph는 범위가 넓기 때문에 이 폴더 아래에서 한 번 더 category로 나눈다.

권장 category:

- `traversal`
- `shortest-path`
- `minimum-spanning-tree`
- `topological-sort`
- `connectivity`

구조 예시는 아래와 같다.

```text
topics/graph/problems/
└─ shortest-path/
   └─ hide-and-seek/
      ├─ problem.md
      ├─ notes.md
      ├─ Solution.java
      └─ SolutionTest.java
```

모든 graph 문제는 `problem.md`와 `notes.md`에 아래 두 항목을 명시한다.

- `Problem Category`
- `Primary Algorithm`

예:

- `Problem Category: traversal`
- `Primary Algorithm: bfs`

이 규칙의 목적은 문제를 열자마자 "graph 중에서도 정확히 무엇으로 푸는 문제인지"를 바로 알 수 있게 하는 것이다.

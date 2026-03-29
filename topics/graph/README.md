# Graph

## Topic Overview

- Topic Name: Graph
- 이 topic을 한 문장으로 설명하면: 정점과 간선의 관계를 모델링하고, 연결성, 탐색, 경로, 비용 문제를 해결하는 알고리즘 주제

## Why This Topic Matters

그래프는 코딩테스트에서 매우 자주 등장하고, 입력이 배열처럼 보여도 실제로는 그래프로 바꿔야 풀리는 문제가 많다.

이 저장소에서 graph는 아래 목표로 학습한다.

- 문제를 그래프로 모델링해야 하는 순간을 익힌다
- BFS와 DFS를 언제 써야 하는지 구분한다
- 최단거리, 연결성, 경로 탐색 문제를 분류하는 감각을 익힌다
- 자료구조와 시간복잡도를 함께 보며 구현 실수를 줄인다

이 topic은 특히 `중하 ~ 중상` 난이도에서 그래프의 핵심 유형을 가장 잘 알려주는 문제에 집중하는 것을 목표로 한다.

즉, 너무 단순한 방문 체크 수준의 문제만 반복하지 않고, 그렇다고 고난도 복합 그래프 문제부터 바로 가지는 않는다.

## Core Concept

- 기본 개념: 문제를 정점과 간선의 관계로 바꾸고, 탐색 또는 경로 계산을 통해 답을 구한다
- 어떤 상황에서 이 topic을 떠올려야 하는가:
  - 연결 관계가 나온다
  - 이동 가능한 경로나 상태 전이가 나온다
  - 도달 가능 여부를 묻는다
  - 최단거리, 최소 이동 횟수, 최소 비용을 묻는다
  - 격자, 지도, 네트워크, 친구 관계 같은 구조가 나온다
- 문제에서 자주 보이는 신호:
  - 연결
  - 방문
  - 경로
  - 최단
  - 최소 이동 횟수
  - 인접
  - 그래프 / 트리 / 네트워크

## What To Check First

문제를 보면 먼저 아래를 확인한다.

1. 이 문제를 정점과 간선으로 바꿔 생각할 수 있는가
2. 배열, 격자, 상태 공간 중 무엇이 그래프 역할을 하는가
3. 답이 연결 여부인지, 방문 순서인지, 경로 수인지, 최단거리인지
4. 간선에 가중치가 있는지
5. 방향 그래프인지 무방향 그래프인지
6. 방문 체크가 필요한지, 중복 방문이 허용되는지

## Complexity Sense

- 자주 나오는 시간복잡도 감각:
  - BFS / DFS는 보통 `O(V + E)`
  - 다익스트라는 보통 `O(E log V)`
  - 플로이드 워셜은 `O(V^3)`
- 입력 크기를 볼 때 먼저 판단할 것:
  - 정점 수와 간선 수를 분리해서 본다
  - 격자 문제는 보통 `row * column`이 정점 수 역할을 한다
  - 가중치가 없으면 BFS가 가능한지 먼저 본다
- 이 topic에서 자주 위험한 비효율:
  - 방문 체크 없이 같은 상태를 반복 탐색하는 것
  - 인접 행렬이 필요 없는데도 써서 메모리를 낭비하는 것
  - 최단거리 문제인데 가중치 유무를 보지 않고 BFS를 쓰는 것

## Implementation Points

- 코드 작성 시 중요한 포인트:
  - 그래프를 어떤 자료구조로 표현할지 먼저 정한다
  - 방문 배열의 의미를 분명히 한다
  - 큐, 스택, 재귀 중 어떤 탐색 구조가 맞는지 정한다
  - 시작 정점과 종료 조건을 정확히 정리한다
- 자주 쓰는 자료구조:
  - 인접 리스트
  - 큐
  - 스택
  - 방문 배열
  - 거리 배열
  - 우선순위 큐
- 구현 시 실수하기 쉬운 부분:
  - 방문 처리 시점 오류
  - 인덱스 범위 체크 누락
  - 방향 / 무방향 간선 추가 실수
  - 가중치 유무를 놓치고 잘못된 알고리즘 선택

## Solving View By Difficulty

- 쉬운 문제에서 주로 보는 것:
  - 연결 요소 탐색
  - 방문 여부 판단
  - 격자 BFS / DFS
  - 단순 최단 거리
- 더 어려운 문제에서 추가로 봐야 하는 것:
  - 상태를 그래프 노드로 바꿔야 하는지
  - 최단거리인데 가중치가 있는지
  - 탐색 중 추가 상태 정보가 필요한지
  - 단순 BFS가 아니라 다익스트라, 위상 정렬, MST 등으로 넘어가야 하는지
- 조건이 바뀌면 다른 알고리즘으로 넘어가는 지점:
  - 가중치가 생기면 BFS에서 다익스트라로 바뀔 수 있다
  - 모든 정점 쌍 최단거리가 필요하면 플로이드 워셜을 본다
  - 연결 비용 최소화라면 MST를 본다

## Representative Problem Level

이 topic에서는 처음부터 너무 쉬운 문제보다, `중하 ~ 중상` 사이에서 그래프 유형을 잘 보여주는 문제를 우선 다룬다.

좋은 대표 문제의 조건은 아래와 같다.

- 그래프 모델링이 분명히 보인다
- BFS / DFS / 최단거리 중 어떤 계열인지 판단할 수 있다
- 방문 처리나 상태 관리가 중요하다
- 시간복잡도를 안 보면 잘못된 접근을 고를 수 있다
- 구현은 복잡하지 않지만 그래프 핵심 감각을 익힐 수 있다

## Common Patterns

그래프에서 자주 만나는 대표 패턴은 아래와 같다.

- 연결 요소 탐색
- 격자 BFS
- 최단 거리
- 상태 공간 탐색
- 위상 정렬
- 최소 신장 트리
- 유니온 파인드 기반 연결 관리

## Internal Categories

graph는 범위가 넓기 때문에, 이 topic 안에서는 문제를 아래 내부 범주로 나눠 관리한다.

- `traversal`
  - BFS, DFS, 연결 요소, 격자 탐색
- `shortest-path`
  - BFS 최단거리, 다익스트라, 벨만포드, 플로이드 워셜
- `minimum-spanning-tree`
  - 크루스칼, 프림
- `topological-sort`
  - 위상 정렬, 선행 조건
- `connectivity`
  - 유니온 파인드, 연결 여부 판단

핵심은 `graph`를 상위 topic으로 유지하되, 실제 문제는 성격에 맞는 내부 category 아래에 넣는 것이다.

## Common Mistakes

- 그래프로 볼 수 있는 문제를 배열 문제처럼만 보는 것
- BFS와 DFS를 감각적으로만 고르는 것
- 방문 체크 시점을 잘못 잡는 것
- 가중치가 있는데 BFS를 쓰는 것
- 인접 리스트와 인접 행렬 선택을 비효율적으로 하는 것

## Related Topics

- 함께 자주 엮이는 topic:
  - `implementation`
  - `shortest-path`
  - `stack-queue`
  - `greedy`
- 헷갈리기 쉬운 topic:
  - 격자 문제를 단순 구현으로만 보는 경우
  - 상태 공간 탐색을 DP와 혼동하는 경우

## How To Use This Topic Folder

이 topic 폴더는 아래 흐름으로 사용한다.

1. 이 문서를 읽고 graph의 공통 판단 기준을 본다
2. `references/practical-checklist.md`로 그래프 문제인지 빠르게 판단한다
3. `references/modeling-checklist.md`로 정점과 간선을 어떻게 잡을지 정리한다
4. 실제 문제를 풀기 전에 `problem.md`로 조건을 정리한다
5. `notes.md`에 그래프 모델링, 알고리즘 후보, 시간복잡도 판단을 적는다
6. `references/implementation-template.md`를 보며 `Solution.java` 구조를 잡는다
7. `SolutionTest.java`에 `sample / limit / trap` 테스트를 만든다
8. 풀이 후 어떤 조건에서 다른 그래프 알고리즘으로 바뀌는지도 기록한다

문제를 추가할 때는 먼저 아래 중 어디에 넣을지 결정한다.

- `problems/traversal/`
- `problems/shortest-path/`
- `problems/minimum-spanning-tree/`
- `problems/topological-sort/`
- `problems/connectivity/`

그리고 각 문제 문서에는 아래 두 항목을 반드시 분명하게 적는다.

- `Problem Category`
- `Primary Algorithm`

예:

- `Problem Category: traversal`
- `Primary Algorithm: bfs`

graph는 범위가 넓기 때문에, 이 두 줄이 있어야 "이 문제가 graph 안에서 정확히 어떤 계열인지"를 한 번에 알 수 있다.

## References

- 자주 참고할 패턴:
  - 그래프 모델링
  - BFS / DFS 선택
  - 방문 체크
  - 거리 배열 관리
- 자주 틀리는 포인트:
  - 방문 처리 시점
  - 간선 방향 처리
  - 가중치가 있을 때의 알고리즘 선택

추가 참고 문서:

- `references/practical-checklist.md`
- `references/modeling-checklist.md`
- `references/implementation-template.md`
- `references/common-patterns.md`
- `references/pitfalls.md`

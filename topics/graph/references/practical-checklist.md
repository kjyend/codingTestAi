# Graph Practical Checklist

이 문서는 실제 graph 문제를 받았을 때 바로 옆에 두고 확인하는 실전 체크리스트다.

## 1. Is This Really A Graph Problem?

먼저 아래 질문에 답한다.

- 연결 관계가 있는가
- 이동 가능한 경로가 있는가
- 방문 여부나 도달 가능 여부를 묻는가
- 격자, 네트워크, 친구 관계를 그래프로 볼 수 있는가
- 최단 거리나 최소 이동 횟수를 묻는가

여기서 여러 개가 맞으면 graph 후보로 강하게 본다.

## 2. Check The Structure

아래를 먼저 구분한다.

- 정점은 무엇인가
- 간선은 무엇인가
- 방향 그래프인가
- 가중치가 있는가
- 시작점과 목표점이 있는가

## 3. Check The Range

- 정점 수 `V`
- 간선 수 `E`
- 격자라면 `row * column`
- BFS / DFS로 되는지, 다익스트라가 필요한지 범위를 보고 판단한다

## 4. Pick Candidate Approaches

`notes.md`에 최소 아래는 적는다.

- 그래프 모델링
- 후보 알고리즘 2~3개
- 왜 BFS / DFS / 다익스트라 중 하나를 선택했는지
- 시간복잡도 판단

## 5. Connect To Files

### `problem.md`

- 입력 / 출력
- 정점과 간선으로 어떻게 해석되는지
- 핵심 범위
- 그래프를 의심하게 만든 표현

### `notes.md`

- 그래프 모델링
- 후보 알고리즘
- 선택 이유
- 시간초과 가능성이 있었던 접근
- 조건이 달라지면 바뀌는 풀이

### `Solution.java`

- 그래프 표현 방식
- 탐색 시작점
- 방문 처리
- 종료 조건

### `SolutionTest.java`

- `sampleCase`
- `limitCase`
- `trapCase`

## 6. Map Risk To Tests

- `sampleCase`
  - 문제 예제 검증
- `limitCase`
  - 정점 / 간선 수가 커졌을 때 비효율한 구현이 드러나는지 확인
- `trapCase`
  - 방문 처리, 방향성, 시작점 / 종료점, 가중치 유무를 잘못 해석하지 않았는지 확인

## Final Rule

핵심은 아래 한 줄이다.

`graph인지 먼저 판단하고, 정점과 간선을 명확히 만든 뒤, 그 구조를 notes와 code와 test에 같은 방식으로 반영한다.`

# Graph Implementation Template

이 문서는 graph 문제를 실제 코드로 옮길 때 어떤 순서로 구현할지 정리한 실전 템플릿이다.

## Core Flow

1. 정점 / 간선 모델링
2. 그래프 표현 방식 결정
3. 방문 / 거리 배열 의미 정의
4. 탐색 구조 결정
5. 종료 조건 확인
6. 테스트 포인트 점검

## 1. Modeling

코드 전에 먼저 적는다.

- 정점은 무엇인가
- 간선은 무엇인가
- 방향성은 있는가
- 가중치는 있는가

## 2. Representation

주로 아래 중 하나를 선택한다.

- 인접 리스트
- 인접 행렬
- 격자 직접 순회
- 상태 생성형 탐색

## 3. State Arrays

먼저 의미를 정한다.

- `visited[node]`는 무엇인가
- `distance[node]`는 무엇인가

## 4. Traversal Choice

- 가중치 없음 + 최단 거리 -> BFS
- 단순 방문 / 연결 여부 -> DFS 또는 BFS
- 가중치 있음 + 최단 거리 -> 다익스트라 후보

## 5. Test Points

- `sampleCase`
- `limitCase`
- `trapCase`

특히 아래를 테스트로 점검한다.

- 방문 처리 시점
- 방향 / 무방향 차이
- 시작점 또는 도달 불가 케이스

## Comment Points

graph 문제는 아래 위치에 짧은 설명 주석을 넣으면 읽기가 좋아진다.

- 정점 / 간선 의미
- 방문 배열 의미
- 거리 배열 의미
- BFS / DFS / 다익스트라를 선택한 이유

## Final Rule

핵심은 아래 한 줄이다.

`모델링 -> 표현 -> 상태 배열 의미 -> 탐색 선택 -> 테스트`

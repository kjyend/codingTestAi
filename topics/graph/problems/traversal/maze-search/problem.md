# Problem

## Basic Info

- Source: Baekjoon Online Judge
- Problem Number: 2178
- Problem Name: 미로 탐색
- URL: https://www.acmicpc.net/problem/2178
- Primary Topic: graph
- Related Topics: traversal, shortest-path
- Problem Category: traversal
- Primary Algorithm: bfs

## Problem Summary

`N x M` 크기의 미로가 주어진다.

각 칸은 이동 가능한 칸 `1` 또는 이동할 수 없는 칸 `0`으로 주어진다.

`(1, 1)`에서 시작해서 `(N, M)`까지 이동할 때, 지나야 하는 칸 수의 최솟값을 구하는 문제다.

상하좌우 인접 칸으로만 이동할 수 있다.

## Input

- 첫째 줄에 두 정수 `N`, `M`이 주어진다
- 다음 `N`개의 줄에는 `M`개의 숫자로 미로가 주어진다
- `N`, `M`은 각각 2 이상 100 이하의 자연수다

## Output

- 시작 위치에서 도착 위치까지 이동할 때 지나야 하는 최소 칸 수를 출력한다

## Important Signals

- 문제를 읽을 때 중요했던 문장:
  - 상하좌우로만 이동할 수 있다
  - 지나야 하는 최소 칸 수를 구한다
- 핵심 표현:
  - 격자
  - 최단 거리
  - 가중치 없음
- 구조 해석:
  - 각 칸을 정점으로 보는 격자 그래프

## Constraints That Matter

- 시간복잡도 상한을 추정하게 만든 제약:
  - `N * M <= 10,000`이라 BFS로 모든 칸을 한 번씩 탐색하는 방식이 적절하다
- 메모리 측면에서 주의할 점:
  - 방문 배열과 거리 배열을 두어도 충분하다
- 이 범위에서 불가능한 접근:
  - 모든 경로를 DFS로 만들어 최솟값을 비교하는 방식
- 이 범위에서 가능한 접근:
  - BFS
  - 격자 그래프 탐색

## First Candidate Algorithms

- 후보 1: BFS
- 후보 2: DFS + 완전탐색
- 후보 3: 다익스트라

## Early Edge Cases

- 가장 먼저 떠오른 반례:
  - 시작점과 도착점이 매우 가까운 경우
  - 한 방향으로만 길이 이어지는 경우
  - 방문 체크를 늦게 해서 같은 칸이 큐에 여러 번 들어가는 경우
- 경계 조건:
  - 가장 작은 크기의 미로
  - 모든 칸이 이동 가능한 경우
  - 돌아가야만 도착 가능한 경우

## Problem Point

- 이 문제의 핵심 포인트:
  - 가중치가 없는 격자 최단 거리이므로 BFS가 가장 자연스럽다
- 조건이 달라지면 바뀌는 풀이:
  - 이동 비용이 칸마다 달라지면 다익스트라 계열을 봐야 한다
  - 최단 거리 대신 단순 도달 가능 여부만 묻는다면 DFS도 가능하다

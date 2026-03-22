# Repository Structure Guide

문제가 많아질수록 폴더를 어떻게 나눌지가 중요해진다.

이 저장소는 플랫폼보다 `topic`을 중심으로 문제를 정리한다.

핵심 목적은 "문제가 어디서 왔는가"보다 "어떤 사고방식과 알고리즘 범주로 풀어야 하는가"를 축적하는 것이다.

## Recommended Default

기본 추천 구조는 아래와 같다.

```text
topics/
└─ {topic}/
   ├─ README.md
   ├─ references/
   └─ problems/
      └─ {problem-slug}/
         ├─ problem.md
         ├─ notes.md
         ├─ Solution.java
         └─ SolutionTest.java
```

예:

```text
topics/
└─ graph/
   ├─ README.md
   ├─ references/
   └─ problems/
      └─ hide-and-seek/
         ├─ problem.md
         ├─ notes.md
         ├─ Solution.java
         └─ SolutionTest.java
```

## Why This Works

- 주제별로 나누면 비슷한 문제를 비교하기 쉽다.
- topic의 기본 개념과 실제 문제를 같은 맥락에서 볼 수 있다.
- 문제별 폴더에서 문서와 코드를 함께 관리할 수 있다.
- 한 폴더 안에 너무 많은 파일이 쌓이는 것을 막을 수 있다.
- 쉬운 문제부터 어려운 문제까지 같은 topic 안에서 성장 흐름을 만들 수 있다.

## What Not To Do Early

초반부터 아래처럼 너무 많은 축을 폴더에 모두 반영하지 않는다.

- 난이도
- 연도
- 월
- 주제
- 상태

이렇게 하면 경로가 너무 길어지고, 문제 하나를 어디에 넣을지 오히려 더 헷갈릴 수 있다.

## Practical Rules

- 1차 분류는 `topic`
- 2차 분류는 `problem-slug`
- 각 topic의 공통 개념은 해당 topic의 `README.md`에 정리한다
- 난이도, 출처, 상태, 풀이 일자는 `problem.md` 안에 적는다
- 문제를 읽고 중요하게 봐야 하는 포인트는 `notes.md`에 남긴다

## Topic File Roles

각 topic 폴더는 아래 역할을 가진다.

- `README.md`: topic의 기본 개념, 떠올려야 하는 신호, 시간복잡도 감각, 자주 쓰는 풀이 흐름
- `references/`: 구현 팁, 자주 하는 실수, 추가 정리 문서
- `problems/`: 실제 문제별 작업물

즉, 공통 이론과 기준은 topic 상위에 두고, 문제별 판단과 복기는 각 문제 폴더 안에 둔다.

## Overlapping Problems

하나의 문제는 여러 topic에 동시에 걸칠 수 있다.

예:

- 그래프이면서 BFS 문제
- DP처럼 보이지만 실제 핵심은 그리디인 문제
- 최단 경로 문제이면서 우선순위 큐가 필요한 문제

이 경우 원칙은 아래와 같다.

- 문제 폴더는 대표 topic 하나에만 둔다
- 같은 문제를 여러 topic에 복사하지 않는다
- 나머지 관련 개념은 `problem.md` 또는 `notes.md`에 적는다

권장 메타 정보:

- `Primary Topic`
- `Related Topics`
- `Alternative Approaches`

## Suggested Topics

처음에는 너무 세분화하지 말고 아래 정도로 시작한다.

- `implementation`
- `data-structure`
- `stack-queue`
- `graph`
- `dfs-bfs`
- `shortest-path`
- `greedy`
- `dp`
- `binary-search`
- `two-pointers`
- `prefix-sum`
- `string`

## When To Add More Topic References

아래 상황이 오면 세분화를 고려한다.

- 특정 주제 폴더에 문제가 너무 많이 쌓였을 때
- topic 안에서 반복적으로 설명해야 하는 패턴이 많아졌을 때
- 특정 학습 흐름을 따로 관리하고 싶을 때

그 전까지는 현재 구조를 유지하는 편이 더 단순하고 좋다.

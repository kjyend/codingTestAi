# Problem Solving Workflow

이 문서는 실제 코딩테스트 문제가 들어왔을 때, 이 저장소에서 어떤 순서로 문제를 읽고 문서를 쓰고 코드를 작성할지 정리한 작업 흐름 문서다.

목표는 문제마다 접근 방식이 크게 흔들리지 않게 만드는 것이다.

## Goal

이 저장소의 문제 풀이 흐름은 아래 4가지를 동시에 만족하는 것을 목표로 한다.

- 문제를 읽는 기준이 일정하다
- 알고리즘 선택 이유가 남는다
- 코드 구조가 크게 흔들리지 않는다
- 테스트가 최소 기준을 만족한다

## Default Workflow

실제 문제를 받으면 아래 순서로 진행한다.

1. 문제를 끝까지 읽는다
2. 입력 크기와 핵심 조건을 먼저 본다
3. 어떤 알고리즘 후보가 가능한지 정리한다
4. `problem.md`에 문제 조건과 핵심 문장을 적는다
5. `notes.md`에 후보 알고리즘과 선택 이유를 적는다
6. 시간복잡도가 범위 안에 드는지 확인한다
7. `Solution.java`를 작성한다
8. `SolutionTest.java`에 최소 3개 테스트를 작성한다
9. 풀이 후 `notes.md`에 반례와 실수 포인트를 보강한다

## Step 1. Read The Problem

문제를 읽을 때 아래를 먼저 확인한다.

- 입력 형식
- 출력 형식
- `N`, `M` 같은 핵심 범위
- 최댓값, 최솟값, 경우의 수, 경로 중 무엇을 구하는지
- 시간초과 위험이 있는지

이 단계에서는 아직 코드를 쓰지 않는다.

## Step 2. Identify Signals

문제 문장에서 어떤 신호가 보이는지 먼저 분류한다.

예:

- 경우의 수
- 최댓값 / 최솟값
- 최소 이동 횟수
- 모든 조합
- 연속 부분 구간

이 단계에서는 [problem-reading-signals.md](/Users/junyoung/workspace/ai_coding_test/docs/guides/problem-reading-signals.md) 를 참고한다.

## Step 3. Compare Candidate Algorithms

후보 알고리즘을 2~3개 정도 떠올리고, 아래를 비교한다.

- 이 범위에서 가능한 시간복잡도인가
- 상태나 구조가 문제와 맞는가
- 더 단순한 알고리즘으로 풀 수 없는가
- 조건이 달라지면 다른 알고리즘이 더 적합한가

이 판단은 `notes.md`에 남긴다.

## Step 4. Fill The Documents First

코드보다 먼저 아래 두 문서를 채운다.

### `problem.md`

아래 내용을 적는다.

- 문제 요약
- 입력 / 출력
- 핵심 범위
- 중요했던 문장
- 먼저 봐야 하는 조건

### `notes.md`

아래 내용을 적는다.

- 핵심 신호
- 후보 알고리즘
- 최종 선택한 알고리즘
- 선택 이유
- 시간복잡도 판단
- 이 문제의 함정

## Step 5. Write `Solution.java`

코드는 아래 흐름을 따른다.

1. package를 정한다
2. `Solution` 클래스를 만든다
3. `main`에서 입력과 출력만 처리한다
4. 핵심 풀이 로직은 `solve` 메서드로 분리한다
5. 보조 메서드는 역할이 드러나는 이름을 사용한다

자세한 규칙은 아래 문서를 따른다.

- [java-naming-conventions.md](/Users/junyoung/workspace/ai_coding_test/docs/guides/java-naming-conventions.md)
- [solution-template.md](/Users/junyoung/workspace/ai_coding_test/docs/templates/solution-template.md)

## Step 6. Write `SolutionTest.java`

테스트는 최소 3개를 작성한다.

- 예제 테스트
- 범위 또는 시간복잡도 관련 테스트
- 함정 또는 반례 테스트

테스트 규칙은 아래 문서를 따른다.

- [test-conventions.md](/Users/junyoung/workspace/ai_coding_test/docs/guides/test-conventions.md)
- [solution-test-template.md](/Users/junyoung/workspace/ai_coding_test/docs/templates/solution-test-template.md)

## Step 7. Update Notes After Solving

풀이가 끝나면 `notes.md`를 다시 본다.

반드시 보강하면 좋은 내용:

- 실제로 맞았던 핵심 포인트
- 처음 생각했던 틀린 접근
- 시간초과 가능성이 있었던 접근
- 반례
- 조건이 달라지면 바뀌는 풀이

## Final Rule

이 저장소에서는 "문제를 보고 바로 코드부터 쓰는 것"보다 아래 순서를 우선한다.

`문제 이해 -> 후보 비교 -> 문서 기록 -> 코드 작성 -> 테스트 -> 복기`

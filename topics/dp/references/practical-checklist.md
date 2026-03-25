# DP Practical Checklist

이 문서는 실제 DP 문제를 받았을 때 바로 옆에 두고 확인하는 실전 체크리스트다.

목표는 DP인지 아닌지 빠르게 판단하고, `problem.md`, `notes.md`, `Solution.java`, `SolutionTest.java`를 채울 때 필요한 결정을 빠뜨리지 않게 하는 것이다.

## 1. Is This Really DP?

먼저 아래 질문에 답한다.

- 같은 계산이 반복되는가
- 현재 답이 이전 상태의 답으로 만들어지는가
- 완전탐색은 가능해 보여도 중복 상태가 너무 많은가
- 답이 최댓값, 최솟값, 경우의 수 형태인가

여기서 여러 개가 맞으면 DP 후보로 강하게 본다.

## 2. Check `N` First

범위를 보고 완전탐색과 DP의 경계를 먼저 판단한다.

- `N`이 작으면 완전탐색도 가능할 수 있다
- `N`이 커서 모든 경우를 보긴 어렵고, 상태 수는 제한적이면 DP가 유력하다
- 상태 수 x 전이 비용이 범위 안에 들어오는지 바로 계산한다

핵심은 "DP처럼 보여서 DP"가 아니라, "범위상 DP가 필요해서 DP"인지까지 보는 것이다.

## 3. Pick Candidate Approaches

`notes.md`에 최소 아래는 적는다.

- 핵심 신호
- 후보 알고리즘 2~3개
- 왜 DP를 선택했는지
- 시간복잡도 판단
- DP가 아니라면 어떤 알고리즘이 더 자연스러울지

특히 아래를 같이 적는다.

- 완전탐색으로는 왜 위험한가
- 그리디나 투 포인터로는 왜 안 되는가

## 4. Write One-Line State Definition

코드 전에 아래 한 줄을 먼저 적는다.

`dp[...]는 무엇을 의미하는가`

이 한 줄이 없으면 `Solution.java`를 바로 쓰지 않는다.

## 5. Connect To Files

실제 파일별로 무엇을 채워야 하는지 빠르게 확인한다.

### `problem.md`

- 입력 / 출력
- `N` 범위
- 중요 문장
- DP를 의심하게 만든 표현

### `notes.md`

- 상태 정의
- 후보 알고리즘
- 선택 이유
- 시간초과 가능성이 있었던 접근
- 조건이 달라지면 바뀌는 풀이

### `Solution.java`

- `solve` 메서드 중심 구조
- base case
- transition
- 반복 순서

### `SolutionTest.java`

- `sampleCase`
- `limitCase`
- `trapCase`

## 6. Map Risk To Tests

테스트 3개는 아래와 연결한다.

- `sampleCase`
  - 문제 예제 검증
- `limitCase`
  - `N` 범위 때문에 시간초과 위험이 있는 구조 점검
- `trapCase`
  - base case, 인덱스, 선택 / 비선택 실수 점검

함정이 많으면 아래도 추가로 본다.

- 모두 같은 값
- 최소 길이
- 한쪽 선택만 반복되는 경우
- 값은 맞아 보이지만 점화식이 틀리는 경우

## 7. Before Finalizing

코드와 테스트를 다 쓴 뒤 마지막으로 본다.

- 상태 정의가 코드와 일치하는가
- base case가 notes 설명과 맞는가
- 시간복잡도가 범위 안에 드는가
- trapCase가 실제 실수 포인트를 잘 찌르는가

## Final Rule

이 문서의 핵심은 아래 한 줄이다.

`DP인지 먼저 판단하고, 상태 정의 한 줄을 만든 뒤, 그 의미를 notes와 code와 test에 같은 방식으로 반영한다.`

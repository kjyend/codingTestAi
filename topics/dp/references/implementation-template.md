# DP Implementation Template

이 문서는 DP 문제를 실제 코드로 옮길 때 어떤 순서로 구현할지 정리한 실전 템플릿이다.

목표는 DP 문제를 풀 때마다 구현 흐름이 크게 흔들리지 않게 만드는 것이다.

## Core Flow

DP 구현은 아래 순서를 기본으로 둔다.

1. 상태 정의
2. base case 정의
3. 점화식 정의
4. 반복 순서 결정
5. 메모리 사용 검토
6. 테스트 포인트 점검

## 1. State Definition

코드를 쓰기 전에 먼저 아래 한 줄을 적는다.

`dp[...]는 무엇을 의미하는가`

예:

- `dp[i]` = i번째까지 고려했을 때의 최댓값
- `dp[i]` = i까지 도달하는 경우의 수
- `dp[i][j]` = i번째까지 봤고, j 상태일 때의 최적값

상태 정의가 한 문장으로 안 되면 코드를 바로 쓰지 않는다.

## 2. Base Case

상태를 정의했으면 가장 작은 입력에서 답이 무엇인지 먼저 정한다.

주로 확인할 것:

- 길이 0
- 길이 1
- 시작 위치
- 첫 번째 행 / 첫 번째 열
- 아무 것도 선택하지 않은 상태

DP는 점화식보다 base case가 먼저 흔들리는 경우가 많다.

## 3. Transition

현재 상태가 어떤 이전 상태에서 오는지 정한다.

확인할 것:

- 이전 몇 개 상태를 참고하는가
- 비교 문제인지 합산 문제인지
- 선택 / 비선택 구조인지
- 전이 하나당 비용이 얼마인지

코드로 바로 옮기기 전에 점화식을 말로 설명할 수 있어야 한다.

## 4. Iteration Order

반복문 순서가 맞지 않으면 점화식이 맞아도 결과가 틀릴 수 있다.

확인할 것:

- 앞에서 뒤로 가야 하는가
- 뒤에서 앞으로 가야 하는가
- 2차원에서 행 우선인지 열 우선인지
- 같은 단계에서 갱신한 값을 다시 써도 되는가

특히 1차원 압축 DP에서는 반복 순서가 더 중요해진다.

## 5. Memory Review

배열 크기를 잡기 전에 메모리를 계산한다.

확인할 것:

- 상태 수가 너무 크지 않은가
- 2차원을 1차원으로 줄일 수 있는가
- 이전 상태 몇 줄만 유지하면 되는가
- `int`로 충분한지 `long`이 필요한가

메모리 압축은 처음부터 억지로 하지 말고, 기본 풀이가 맞는지 본 뒤 고려해도 된다.

## 6. Test Points

구현을 마치기 전에 아래 테스트 포인트를 바로 떠올린다.

- `sampleCase`
  - 문제 예제가 그대로 맞는가
- `limitCase`
  - `N` 범위가 커졌을 때 시간복잡도상 위험한 부분이 없는가
- `trapCase`
  - base case, 인덱스, 선택 / 비선택, 빈 상태 같은 함정을 놓치지 않았는가

## Comment Points

DP 문제는 아래 위치에 짧은 설명 주석을 넣으면 읽기가 훨씬 좋아진다.

- 상태 정의 바로 위
- base case 초기화 바로 위
- 점화식이 적용되는 반복문 바로 위
- 함정 조건을 처리하는 분기 바로 위

예:

- `dp[i]`의 의미
- 왜 `i-2`와 `i-3`을 비교하는지
- 왜 이 반복 순서가 필요한지

주석은 짧고 핵심만 적고, 코드 한 줄마다 설명을 붙이지는 않는다.

## Minimal Coding Shape

DP 문제는 보통 아래 흐름으로 코드가 정리된다.

```java
int solve(int[] numbers) {
    int length = numbers.length;
    int[] dp = new int[length];

    // base case

    for (int i = 1; i < length; i++) {
        // transition
    }

    return dp[length - 1];
}
```

2차원이라면 아래처럼 본다.

```java
int solve(int[][] board) {
    int rowCount = board.length;
    int columnCount = board[0].length;
    int[][] dp = new int[rowCount][columnCount];

    // base case

    for (int row = 0; row < rowCount; row++) {
        for (int column = 0; column < columnCount; column++) {
            // transition
        }
    }

    return dp[rowCount - 1][columnCount - 1];
}
```

핵심은 코드 모양을 외우는 것이 아니라, 상태와 전이 의미가 코드에 자연스럽게 보이도록 하는 것이다.

## Final Reminder

DP 구현 순서는 아래 한 줄로 기억한다.

`상태 정의 -> base case -> 점화식 -> 반복 순서 -> 메모리 -> 테스트`

# Solution Template

이 문서는 `Solution.java`를 어떤 구조로 작성할지에 대한 기본 템플릿이다.

목표는 문제마다 코드 뼈대가 크게 흔들리지 않게 만드는 것이다.

## File Role

`Solution.java`는 실제 정답 코드를 담는 파일이다.

기본 역할은 아래와 같다.

- 입력 받기
- 핵심 풀이 실행
- 출력 만들기

## Default Structure

기본 구조는 아래 흐름을 따른다.

```java
package topics.<topic>.problems.<problem_slug>;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // input parsing

        Solution solution = new Solution();
        String result = solution.solve();

        System.out.println(result);
    }

    String solve() {
        // core logic
        return "";
    }
}
```

## Recommended Rule

아래 규칙을 기본으로 둔다.

- 클래스 이름은 `Solution`
- 핵심 메서드 이름은 가능하면 `solve`
- `main`은 입력과 출력 중심
- 핵심 알고리즘은 별도 메서드로 분리
- helper 메서드는 역할이 드러나는 이름 사용

## Practical Variants

문제에 따라 `solve` 메서드는 아래처럼 달라질 수 있다.

- `int solve(...)`
- `long solve(...)`
- `String solve(...)`
- `int[] solve(...)`
- `List<Integer> solve(...)`

핵심은 반환형이 무엇이든, 풀이의 중심 메서드를 한 군데로 모으는 것이다.

## Input Handling Rule

입력이 단순하면 `main`에서 바로 파싱해도 된다.

입력이 복잡하면 아래처럼 분리한다.

- `readInput`
- `parseGraph`
- `buildArray`

단, 문제 규모가 작을 때 불필요하게 메서드를 너무 많이 나누지는 않는다.

## Helper Method Rule

보조 메서드는 알고리즘 역할이 드러나야 한다.

예:

- `bfs`
- `dfs`
- `dijkstra`
- `buildGraph`
- `isValid`

피해야 하는 이름:

- `doIt`
- `run`
- `temp`
- `process`

## Comment Guideline

`Solution.java`에는 짧은 핵심 설명 주석을 넣을 수 있다.

권장되는 위치:

- 상태 정의 바로 위
- base case 설정 바로 위
- 점화식 또는 핵심 전이 바로 위
- 실수하기 쉬운 조건 분기 바로 위

권장 예:

```java
// dp[i] = i번째 계단을 반드시 밟고 도착했을 때의 최대 점수
int[] dp = new int[stairCount];

// i번째 계단은 i-2에서 바로 오거나, i-3에서 i-1을 거쳐 올 수 있다.
dp[index] = Math.max(skipPrevious, takePrevious);
```

핵심은 코드보다 설명이 많아지지 않게, 이해에 꼭 필요한 부분만 짧게 적는 것이다.

## DP Style Example

DP 문제라면 이런 식으로 갈 수 있다.

```java
int solve(int[] numbers) {
    int length = numbers.length;
    int[] dp = new int[length];

    dp[0] = numbers[0];

    for (int i = 1; i < length; i++) {
        dp[i] = Math.max(dp[i - 1], numbers[i]);
    }

    return dp[length - 1];
}
```

여기서 중요한 건 점화식보다 먼저 `dp[i]`의 의미를 정하는 것이다.

## Before Writing Code

코드 쓰기 전에 아래를 먼저 적어본다.

- 이 메서드의 입력은 무엇인가
- 반환값은 무엇인가
- 핵심 상태는 무엇인가
- 시간복잡도는 얼마인가

## Final Rule

이 템플릿은 코드를 똑같이 복붙하기 위한 문서가 아니다.

핵심은 아래 세 가지다.

1. `Solution.java`의 구조가 문제마다 크게 흔들리지 않게 한다
2. `main`과 핵심 로직을 가능한 한 분리한다
3. 읽는 사람이 바로 이해할 수 있는 이름을 사용한다

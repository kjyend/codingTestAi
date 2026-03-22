# Java Naming Conventions

이 문서는 이 저장소에서 Java 코드를 작성할 때 이름과 파일 구조를 일관되게 맞추기 위한 규칙을 정의한다.

목표는 "문제마다 스타일이 달라지는 것"을 줄이고, Codex와 사람이 함께 작업해도 비슷한 결과가 나오게 만드는 것이다.

## Scope

이 문서는 아래 항목의 기본 규칙을 다룬다.

- topic 폴더 안의 문제 경로
- Java 파일 이름
- package 이름
- 클래스 이름
- 메서드 이름
- 변수와 필드 이름
- 상수 이름

테스트 코드 세부 규칙은 별도 테스트 문서에서 더 자세히 다룬다.

## Problem Path Rule

문제는 아래 구조를 기본으로 둔다.

```text
topics/{topic}/problems/{problem-slug}/
```

예:

```text
topics/graph/problems/hide-and-seek/
topics/dp/problems/longest-increasing-subsequence/
```

규칙:

- topic 이름은 소문자 kebab-case를 사용한다
- problem slug도 소문자 kebab-case를 사용한다
- 공백은 쓰지 않는다
- 의미가 너무 짧거나 모호한 이름은 피한다

## Package Rule

package는 경로를 따라가되, Java 관례에 맞게 소문자와 점 표기를 사용한다.

기본 형식:

```java
package topics.<topic>.problems.<problem_slug>;
```

예:

```java
package topics.graph.problems.hide_and_seek;
package topics.dp.problems.longest_increasing_subsequence;
```

규칙:

- package는 전부 소문자
- 하이픈은 package에서 사용할 수 없으므로 underscore로 바꾼다
- package는 폴더 구조를 최대한 반영한다
- 특별한 이유가 없다면 package를 생략하지 않는다

## File And Class Rule

문제 폴더 안의 기본 Java 파일 이름은 아래를 따른다.

- `Solution.java`
- `SolutionTest.java`

기본 규칙:

- 풀이 메인 클래스 이름은 `Solution`
- 테스트 클래스 이름은 `SolutionTest`
- 문제마다 클래스명을 다르게 만들지 않는다

이 규칙의 목적은 문제별 파일 구조를 일정하게 유지하는 것이다.

## Method Naming Rule

메서드 이름은 역할이 드러나게 짓는다.

권장 예:

- `solve`
- `bfs`
- `dfs`
- `dijkstra`
- `isValid`
- `buildGraph`
- `calculateDistance`

규칙:

- 메서드 이름은 camelCase
- 문제 전체를 푸는 핵심 메서드는 가능하면 `solve`를 우선 사용한다
- 알고리즘 보조 메서드는 역할이 드러나는 동사형 이름을 사용한다
- `doThing`, `temp`, `func` 같은 모호한 이름은 피한다

## Variable And Field Rule

변수와 필드는 읽는 사람이 바로 의미를 알 수 있게 짓는다.

기본 규칙:

- 변수명과 필드명은 camelCase
- 의미가 분명한 이름을 우선한다
- 너무 짧은 축약형은 피한다

권장 예:

- `nodeCount`
- `edgeCount`
- `visited`
- `distances`
- `adjacentList`
- `currentNode`
- `nextCost`

허용되는 짧은 이름:

- 반복문 인덱스 `i`, `j`, `k`
- 좌표 관용 표현 `x`, `y`
- 수학적으로 명확한 `n`, `m`

단, `n`, `m`, `k`를 사용하면 해당 값이 무엇인지 주변 문맥에서 바로 드러나야 한다.

## Constant Rule

상수는 `UPPER_SNAKE_CASE`를 사용한다.

예:

- `INF`
- `MAX_SIZE`
- `DIRECTIONS`

규칙:

- 변하지 않는 값만 상수로 둔다
- 의미 없는 숫자는 가능한 한 상수로 뽑는다
- 문제 특성상 널리 쓰이는 값은 이름으로 의미를 드러낸다

## Data Structure Naming Rule

자료구조 변수는 안에 무엇이 들어 있는지 보이게 짓는다.

권장 예:

- `queue`
- `stack`
- `priorityQueue`
- `graph`
- `adjacentList`
- `indegree`
- `parent`
- `rank`
- `dp`

설명:

- `queue`로 충분히 의미가 드러나면 그대로 사용한다
- 그래프는 `graph`보다 `adjacentList`가 더 정확하면 더 구체적인 이름을 쓴다
- DP 배열은 기본적으로 `dp`를 허용하되, 여러 개가 있으면 `maxDp`, `countDp`처럼 목적을 붙인다

## Input And Output Naming Rule

입출력 관련 이름도 일정하게 유지한다.

권장 예:

- `reader`
- `writer`
- `tokenizer`
- `input`
- `output`

규칙:

- 빠른 입력이 필요하면 `BufferedReader`와 `StringTokenizer`를 우선 검토한다
- 출력 누적이 필요하면 `StringBuilder`를 우선 검토한다
- 입출력 객체 이름은 문제마다 크게 흔들리지 않게 한다

## Implementation Style Rule

이 저장소의 기본 구현 스타일은 아래와 같다.

- 핵심 로직은 가능하면 별도 메서드로 분리한다
- 메인 입출력과 알고리즘 로직을 가능하면 나눈다
- 테스트 가능성이 중요하면 순수 로직 메서드를 우선 만든다
- 불필요한 클래스 분리는 하지 않는다

## Examples

좋은 예:

- folder: `topics/graph/problems/hide-and-seek`
- package: `topics.graph.problems.hide_and_seek`
- class: `Solution`
- method: `solve`
- variable: `visited`, `queue`, `currentPosition`

피하고 싶은 예:

- folder: `topics/Graph/Problems/hideAndSeek`
- class: `HideAndSeekSolution`
- method: `doIt`
- variable: `a`, `tmp1`, `value2`

## Final Rule

이 문서의 목적은 지나치게 엄격한 규칙을 늘리려는 것이 아니다.

핵심은 아래 세 가지다.

1. 문제마다 폴더와 파일 이름이 흔들리지 않게 한다
2. 클래스와 메서드 이름이 예측 가능하게 유지되게 한다
3. 나중에 여러 문제를 다시 봐도 구조를 바로 이해할 수 있게 한다

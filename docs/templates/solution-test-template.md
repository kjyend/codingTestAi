# Solution Test Template

이 문서는 `SolutionTest.java`를 어떤 기준으로 시작할지 정리한 기본 템플릿이다.

테스트는 복잡하게 많이 만드는 것보다, 큰 실수를 잡는 최소 구성을 유지하는 것을 목표로 한다.

## File Role

`SolutionTest.java`는 아래를 검증한다.

- 예제 입력이 맞는지
- 범위나 시간복잡도에서 큰 문제가 없는지
- 함정이나 반례를 놓치지 않았는지

## Default Class Name

테스트 클래스 이름은 항상 아래를 사용한다.

```java
public class SolutionTest
```

## Minimum Structure

기본 구조는 아래와 같다.

```java
class SolutionTest {

    @Test
    void sampleCase() {
    }

    @Test
    void limitCase() {
    }

    @Test
    void trapCase() {
    }
}
```

## Minimum Rule

모든 문제는 최소 3개의 테스트를 가진다.

- `sampleCase`
- `limitCase`
- `trapCase`

함정이 많으면 테스트를 더 추가한다.

## What Each Test Means

### `sampleCase`

- 문제 예제를 그대로 확인한다

### `limitCase`

- 입력 범위나 반복 구조 때문에 비효율 풀이가 드러나는지 확인한다

### `trapCase`

- 자주 틀리는 반례나 경계 조건을 확인한다

## Notes Connection

테스트를 만들 때는 `notes.md`를 같이 본다.

특히 아래 항목과 연결한다.

- 시간초과 가능성이 있었던 접근
- 실수 포인트
- 반례

즉, `notes.md`에 적힌 위험 요소가 테스트에도 반영되면 가장 좋다.

## Final Rule

이 템플릿의 목적은 테스트를 많이 쓰는 것이 아니다.

핵심은 아래 한 줄이다.

`예제, 범위, 함정 테스트를 최소 기준으로 유지하고, 문제의 위험 요소가 보이면 테스트를 더 추가한다.`

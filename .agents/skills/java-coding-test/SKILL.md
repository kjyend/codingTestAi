---
name: java-coding-test
description: Use this skill when solving coding test problems in Java, organizing solution structure, or converting examples into tests for this repository.
---

# Java Coding Test Skill

이 스킬은 이 저장소에서 Java 코딩테스트 문제를 일관된 방식으로 풀기 위해 사용한다.

## When To Use

- 새로운 코딩테스트 문제를 Java로 풀어야 할 때
- 문제의 예제 입력과 출력을 테스트 코드로 바꿔야 할 때
- 기존 Java 풀이를 더 읽기 쉽게 리팩터링해야 할 때
- 시간복잡도와 공간복잡도 설명까지 함께 정리해야 할 때

## Repository Intent

- 이 저장소는 Java 기반 코딩테스트 학습용 저장소다.
- 정답 코드만 만드는 것보다, 재사용 가능한 풀이 패턴과 테스트 습관을 만드는 것을 더 중요하게 본다.
- Codex는 가능한 한 일관된 형식으로 결과물을 남겨야 한다.

## Default Workflow

1. 문제 요구사항을 짧게 요약한다.
2. 입력 크기와 제약 조건이 보이면 풀이 전략을 먼저 선택한다.
3. 브루트포스보다 적절한 자료구조와 알고리즘을 우선 검토한다.
4. Java 메서드 단위로 테스트 가능한 풀이 구조를 만든다.
5. 예제 입력과 출력이 있으면 테스트 케이스로 추가한다.
6. 시간복잡도와 공간복잡도를 정리한다.

## Implementation Preferences

- 기본 언어는 Java다.
- 특별한 사유가 없다면 표준 라이브러리 중심으로 해결한다.
- 과도한 객체 설계보다 문제 풀이에 적합한 단순한 구조를 우선한다.
- 핵심 알고리즘은 별도 메서드로 분리해 테스트 가능성을 높인다.
- 입출력 파싱과 순수 로직은 가능하면 나눠서 작성한다.

## Output Checklist

- 문제 요약이 있는가
- 풀이 아이디어가 설명되었는가
- Java 코드가 포함되었는가
- 테스트 케이스 또는 검증 방법이 포함되었는가
- 시간복잡도와 공간복잡도가 적혔는가

## Guardrails

- 검증되지 않은 가정을 정답처럼 단정하지 않는다.
- 테스트가 부족하면 부족한 이유를 분명히 말한다.
- 불필요한 프레임워크 도입을 피한다.
- 저장소 구조가 확정되지 않았다면 최소한의 파일만 만든다.

## Example Requests

- "이 문제를 Java로 풀고 테스트도 같이 만들어줘"
- "이 입력 예시를 JUnit 테스트로 바꿔줘"
- "기존 풀이의 시간복잡도를 설명하고 리팩터링해줘"

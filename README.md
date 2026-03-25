# codingTestAi

Java 기반 코딩테스트 학습과 문제 풀이를 위한 저장소입니다.

이 저장소의 목표는 두 가지입니다.

1. Java로 코딩테스트 문제를 일관된 방식으로 풀이하고 테스트한다.
2. Codex가 저장소 규칙을 이해하고, 반복 작업을 안정적으로 수행할 수 있도록 문서와 스킬을 함께 관리한다.

## Project Goals

- Java 중심의 코딩테스트 풀이 저장소로 운영한다.
- 문제 풀이, 테스트 코드, 복잡도 설명을 함께 남긴다.
- Codex가 같은 방식으로 반복 작업할 수 있도록 저장소 규칙을 문서화한다.
- 문제를 읽고 어떤 알고리즘을 떠올려야 하는지 판단 기준까지 축적한다.

## Planned Structure

```text
codingTestAi/
├─ README.md
├─ AGENTS.md
├─ docs/
│  ├─ guides/
│  │  ├─ java-naming-conventions.md
│  │  ├─ problem-solving-workflow.md
│  │  ├─ problem-reading-signals.md
│  │  ├─ repository-structure.md
│  │  └─ test-conventions.md
│  └─ templates/
│     ├─ topic-template.md
│     ├─ problem-template.md
│     ├─ notes-template.md
│     ├─ solution-template.md
│     └─ solution-test-template.md
├─ .agents/
│  └─ skills/
│     └─ java-coding-test/
│        └─ SKILL.md
├─ topics/
│  ├─ README.md
│  └─ {topic}/
│     ├─ README.md
│     ├─ problems/
│     │  └─ {problem-slug}/
│     │     ├─ problem.md
│     │     ├─ notes.md
│     │     ├─ Solution.java
│     │     └─ SolutionTest.java
│     └─ references/
├─ src/
└─ build.gradle
```

## How We Intend To Use Codex

- `README.md`는 사람을 위한 프로젝트 안내 문서다.
- `AGENTS.md`는 Codex가 이 저장소에서 따라야 하는 작업 규칙을 담는다.
- `.agents/skills/.../SKILL.md`는 반복적으로 요청할 작업을 템플릿화한다.
- `docs/guides/`는 문제 해석 기준과 저장소 운영 기준을 모아두는 곳이다.
- `docs/guides/java-naming-conventions.md`는 Java 코드의 이름과 파일 구조를 일정하게 맞추기 위한 기준 문서다.
- `docs/guides/problem-solving-workflow.md`는 실제 문제를 받을 때 어떤 순서로 작업할지 정리한 문서다.
- `docs/guides/test-conventions.md`는 문제별 테스트를 어떤 수준까지 작성할지 정하는 기준 문서다.
- `docs/templates/`는 새 문제를 추가할 때 복사해서 시작하는 기본 문서 템플릿이다.
- `topics/`는 알고리즘 주제별 기준 문서와 실제 문제 풀이를 함께 관리하는 곳이다.

예를 들어 아래와 같은 작업을 Codex에 안정적으로 맡기는 것을 목표로 한다.

- Java로 알고리즘 문제 풀이 작성
- 입력 예제를 테스트 코드로 변환
- 시간복잡도와 공간복잡도 설명 추가
- 기존 풀이 리팩터링 및 테스트 보강

## Working Principles

- 풀이 언어는 기본적으로 Java를 사용한다.
- 가능한 경우 테스트 가능한 구조로 작성한다.
- 문제 풀이 시 핵심 아이디어와 복잡도를 함께 기록한다.
- 복잡한 자동화보다 먼저, 사람이 읽을 수 있는 명확한 문서를 우선한다.

## Problem Unit Convention

문제 하나는 아래 4개 파일을 기본 단위로 관리한다.

- `problem.md`: 문제 요약, 입력/출력, 제약, 문제를 읽을 때 중요했던 문장 정리
- `notes.md`: 어떤 알고리즘 후보를 떠올렸는지, 왜 그 풀이를 선택했는지, 반례와 복기
- `Solution.java`: 실제 정답 코드
- `SolutionTest.java`: 예제와 반례 검증 코드

이 방식의 장점은 문제 원문 이해, 코드, 복기를 분리할 수 있다는 점이다.

## Topic Strategy

이 저장소는 플랫폼보다 `topic`을 기준으로 문제를 분류한다.

즉, `graph`, `dp`, `greedy` 같은 큰 주제 폴더를 먼저 만들고, 그 안에 실제 문제를 넣는다.
이 방식의 목적은 "어디서 나온 문제인가"보다 "어떤 사고방식으로 풀어야 하는가"를 더 잘 축적하기 위해서다.

예시:

```text
topics/
└─ dp/
   ├─ README.md
   ├─ references/
   └─ problems/
      └─ target-number/
         ├─ problem.md
         ├─ notes.md
         ├─ Solution.java
         └─ SolutionTest.java
```

각 topic 폴더의 역할은 아래와 같다.

- `README.md`: 그 topic의 기본 개념, 언제 떠올려야 하는지, 어떤 부분이 중요한지
- `references/`: 구현 팁, 자주 틀리는 포인트, 관련 정리 문서
- `problems/`: 실제 문제별 작업물

난이도, 출처, 날짜, 관련 알고리즘은 폴더를 늘리기보다 `problem.md`나 `notes.md` 내부 메타 정보로 적는 편이 더 관리하기 쉽다.

## Overlapping Problems

하나의 문제가 여러 topic에 걸칠 수는 있지만, 문제 폴더는 한 곳에만 둔다.

- 대표 topic 하나만 선택한다.
- 나머지는 `problem.md` 또는 `notes.md`에 관련 topic으로 남긴다.
- 같은 문제를 여러 폴더에 복사하지 않는다.

예:

- Primary Topic: `graph`
- Related Topics: `bfs`, `shortest-path`

## Next Steps

- Java 프로젝트 골격을 추가한다.
- topic 템플릿을 기준으로 상위 문서를 먼저 다듬는다.
- 템플릿을 복사해서 문제 풀이 루틴을 고정한다.

# Topics Directory

이 폴더는 알고리즘 주제별 기준 문서와 실제 문제 풀이를 함께 관리하는 공간이다.

이 저장소는 플랫폼보다 `topic` 중심으로 문제를 정리한다.

예:

- `topics/graph/`
- `topics/dp/`
- `topics/greedy/`

각 topic 폴더는 보통 아래 구조를 따른다.

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

공통 개념은 topic 상위 문서에 두고, 문제별 판단과 복기는 각 문제 폴더 안에 남긴다.

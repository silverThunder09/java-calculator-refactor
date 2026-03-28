# Calculator Project_V2

## 📌 프로젝트 소개
Java로 구현한 사칙연산 계산기입니다.
단계별로 클래스, 캡슐화, Enum, 제네릭, 람다 & 스트림을 적용하여 구현

### STEP 1 - 기본 계산기
- 사칙연산 (+, -, *, /)
- 잘못된 입력 예외처리
- exit 입력 시 종료

### STEP 2 - 클래스 적용
- Calculator 클래스로 연산 분리
- 연산 결과 컬렉션 저장
- 캡슐화 (private, Getter/Setter)
- 첫 번째 결과 삭제 기능

### STEP 3 - 심화
- Enum으로 연산자 타입 관리
- 제네릭으로 다양한 타입 지원 (Integer, Double 등)
- 람다 & 스트림으로 결과 조회


## 📝 Git Commit Message Convention

| 타입 (Type) | 설명 (Description) |
| :--- | :--- |
| **feat** | 새로운 기능 추가 |
| **fix** | 버그 수정 |
| **docs** | 문서 변경 |
| **style** | 코드 포맷팅, 세미콜론 누락 등 코드 변경이 없는 경우 |
| **refactor** | 코드 리팩토링 (기능 변경 없음) |
| **test** | 누락된 테스트 추가 또는 기존 테스트 수정 |
| **chore** | 빌드 프로세스 또는 보조 도구 수정 (라이브러리 추가 등) |
| **perf** | 성능 향상 관련 변경 |
| **build** | 빌드 관련 파일 변경 |
| **ci** | CI 관련 설정 변경 |
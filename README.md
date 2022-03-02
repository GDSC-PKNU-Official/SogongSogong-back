# SogongSogong-back 
솔루션챌린지 소공소공 백엔드

---
## Github 전략
### 1 Main : 2 Branch
- Main => 소공소공 백엔드 메인파일
- TreeJin_Branch => 남우진's 소스코드
- Chodakk_Branch => 조다은's 소스코드

### Main Merge 방식
- 각자의 Branch를 만들어 코드를 작성한다.
- 코드 작성이 완료되면 각자 브랜치로 Commit & Push를 한다.
- 이후 본인의 브랜치를 Main으로 Pull Request를 추가한 뒤 설명을 한다.
- 각자 Pull Request에 대한 리뷰를 남긴 후 Merge를 승인한다.

### 구조
1. Entity
    - 실제 DB(MySQL)에 저장하기 위한 클래스.
    - DB의 테이블을 객체화한다.
    - 테이블 이름, column에 대한 정보가 들어 있다.
    
2. Repository(DAO)
    - Entity에 접근하여 기본적인 CRUD 작업을 담당하는 interface.
    - DB data -> Service하는 역할.
    - JpaRepository<Entity, Id자료형>을 상속 받는다.
    
3. DTO
    - 계층(Controller, View 등)간 데이터 교환을 위한 객체(Beans).
    - DB data -> Controller하는 역할.
    - 로직을 갖고 있지 않다.
    
4. Controller
    - 사용자의 요청을 어떻게 처리할지 결정하여 Service 객체에 넘기는 파트
    
5. Service
    - Controller에서 받은 요청에 대해 어떤 처리를 할지 결정하는 파트
    - 여러 Repository(DAO)를 호출하여 데이터를 접근/갱신하고 비즈니스 로직을 수행.

# BE

- JAVA 17이상..  
- IDE  
  - IntelliJ  
  - Eclipse  
  - VScode

# DB

- PotgresSQL

# ORM

- JPA  
  - 한참공부…  
- QueryDSL(option)  
- MyBatis

	

# 패키징

- Gradle(반드시\!)

\= \> 이제 메이븐 안쓰구요. 느려요.

# 패키지 명

- com.abc  
  - controller  
    - aController.java  
  - repo  
    - aRepository.java  
      - MyBaits  
      - JPA  
  - entity  
    - aEntity.java  
  - vo  
    - aVo.java  
  - service  
    - aService.java  
  - serviceImpl  
    - a.ServiceImpl.java

- ctr(vo) \-\> svc \-\> svcImpl(domain/entity) \-\> repo \-\> db

## 구조

- 단순

## API 설계

- 기준  
  - [https://cloud.google.com/apis/design?hl=ko](https://cloud.google.com/apis/design?hl=ko)  
- GET/POST(READ)	  
  - GET /comm/v1/code/  
- GET/POST(READ)  
  - GET /comm/v1/code/{code}  
- POST(CREATE)  
  - /comm/v1/code.  
- PUT(UPDATE)  
  - PUT /comm/v1/code/{code}  
- DELETE  
  - PUT /comm/v1/code/{code}

## 단어표준

# 기타

- api g/w  
  - 별게 없을 수 있음.  
- oauth\*  
  - authentication  
  - authorization  
  - sso  
- alarm(polling)  
  - http2  
  - soce  
- queue\*  
  - kafka  
  - mq  
- monitoring  
  - prometheus  
  - scouter  
- logging  
  - centralized logging(e.g. EFK, ELK)  
- docs  
  - openDocs(or springFOX, swagger)  
- TDD  
  - Junit  
- MSA  
  - kkkkk  
- CI/CD  
  - jenkins  
  - Git Action

# 테스트

- 기본CRUD만든다.

# FE

# Vue

- vue3  
  - vite  
  - pinya  
- vuex  
  - ?  
- nuxt.js  
  - ?


- 디자인  
  - vuetify3

—

# 일정

- WBS


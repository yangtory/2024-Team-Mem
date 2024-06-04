<p align="center">
  <img width="612" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/a982f43e-ee9b-4820-a563-07d053240a60">
</p>

## 프로젝트 소개
- ‘Mem’ 은 Member 에서 따온 단어로 헬스, 요가, 필라테스 등 회원관리가 필요한 스포츠 시설을 타겟으로 한 웹 서비스 입니다.
- 시중의 서비스를 보고 프로그램의 흐름 파악하여 초보자도 쉽게 사용할 수 있도록 설계하였습니다.
- 개발기간 : 2024.04~2024.05
- 플랫폼 : Web
  
## 팀원 구성
|양정연|김승희|
|------|---|
|<img width="200px" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/4dd13ed9-5ed4-4c9e-b40c-ff42a4ac6900">|<img width="200px" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/22a1d0f1-9b66-45ed-b9c3-174d8606d992">|
|[@yangtory](https://github.com/yangtory)|[@Kwinhui](https://github.com/Kwinhui)|

## 1. 개발환경
- 언어 : Java (1.8), HTML/CSS, JavaScript, JSP
- 서버 : Apache Tomcat 9.0
- 프레임워크 : Spring Framework 3.2.25,  MyBatis, Spring Security
- DB : MySQL
- IDE : STS3
- API, 라이브러리 : RESTful API, Jackson, Chart.js, AOS lib
- 협업 : Github, Notion

## 2. 역할분담
### 🐱 양정연
- 레이아웃 구성, 디자인 컨셉
- 페이지 : 메인 소개 페이지, 로그인 및 회원가입, 회원권관리, 강사관리, 매출관리, 공지사항
- 기능 : Spring Security를 사용한 세션, 토큰 설정 / 회원권, 강사, 매출, 공지사항 관리 CRUD

### 🐶 김승희
- 노션 회의 기록
- 페이지 : 대시보드, 회원관리, 수업관리, 스케줄관리
- 기능 : Chart.js를 사용한 대시보드 구현 / 수업, 스케줄 관리 달력 / 회원관리 CRUD 

## 3. ERD
<img width="972" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/51b30e15-1ee9-41c7-9d1c-66148f0f4050">

## 4. 페이지
### [메인 소개 페이지]
- AOS Lib 를 사용하여 구현
    - 로그인이 되어있는 경우 : 대시보드 페이지
    - 로그인이 되어 있지 않은 경우 : 메인 소개 페이지

![화면 기록 2024-06-04 15 00 48-1](https://github.com/yangtory/2024-Team-Mem/assets/151486114/311c598a-5c00-493a-8b33-c609828983a3)

### [로그인 및 회원가입]
- 회원가입
  - 업체 정보를 입력하면 관리자 회원으로 가입
  - 입력하지 않으면 일반 회원으로 가입

![화면 기록 2024-06-04 15 12 08-1](https://github.com/yangtory/2024-Team-Mem/assets/151486114/2a1d563d-252f-470c-ae0a-a9854427c024)

### [대시보드]
- Chart.js 를 사용하여 구현
  
|데이터가 없는 경우|데이터가 있는 경우|
|--------------|-------------|
|<img width="500px" alt="스크린샷 2024-06-04 15 21 56" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/9d24cddb-0548-4c89-a1c7-ed2a09cd9723">|<img width="500px" alt="스크린샷 2024-06-04 15 23 51" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/06ac8cc0-3c84-4864-af2c-7d4ea3fcac2a">|

### 

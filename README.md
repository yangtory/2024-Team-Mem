<p align="center">
  <img width="612" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/a982f43e-ee9b-4820-a563-07d053240a60">
</p>

## 프로젝트 소개
- ‘Mem’ 은 Member 에서 따온 단어로 헬스, 요가, 필라테스 등 회원관리가 필요한 스포츠 시설을 타겟으로 한 웹 서비스 입니다.
- 시중의 서비스를 보고 프로그램의 흐름 파악하여 초보자도 쉽게 사용할 수 있도록 설계하였습니다.
- 개발기간 : 2024.04~2024.05
- 플랫폼 : Web
<br/>
  
## 팀원 구성
|양정연|김승희|
|------|---|
|<img width="200px" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/4dd13ed9-5ed4-4c9e-b40c-ff42a4ac6900">|<img width="200px" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/22a1d0f1-9b66-45ed-b9c3-174d8606d992">|
|[@yangtory](https://github.com/yangtory)|[@Kwinhui](https://github.com/Kwinhui)|
<br/>

## 1. 개발환경
- 언어 : Java (1.8), HTML/CSS, JavaScript, JSP
- 서버 : Apache Tomcat 9.0
- 프레임워크 : Spring Framework 3.2.25,  MyBatis, Spring Security
- DB : MySQL
- IDE : STS3
- API, 라이브러리 : RESTful API, Jackson, Chart.js, AOS lib
- 협업 : Github, Notion
<br/>

## 2. 역할분담
### 🐱 양정연
- 레이아웃 구성, 디자인 컨셉, 리드미 작성
- 페이지 : 메인 소개 페이지, 로그인 및 회원가입, 회원권관리, 강사관리, 매출관리, 공지사항
- 기능 : Spring Security를 사용한 세션, 토큰 설정 / 회원권, 강사, 매출, 공지사항 관리 CRUD

### 🐶 김승희
- 노션 회의 기록
- 페이지 : 대시보드, 회원관리, 수업관리, 스케줄관리
- 기능 : Chart.js를 사용한 대시보드 구현 / 수업, 스케줄 관리 달력 / 회원관리 CRUD 
<br/>

## 3. ERD
<img width="972" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/51b30e15-1ee9-41c7-9d1c-66148f0f4050">
<br/>
<br/>

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

### [회원권 관리]
- 업체에서 사용하는 회원권 관리 페이지
- 회원권 CRUD 구현

|회원권 리스트|회원권 등록|회원권 디테일|
|--------------|-------------|-------------|
|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/c8a56630-d29f-460e-861b-81f4fef5152c">|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/f97060f6-6e16-4232-85b4-3ab74b3d2c6a">|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/9511f5a7-9813-47a3-8d3b-68a59a0f0801">

### [회원관리]
- 회원 CRUD 구현
- 회원 등록하면서 회원권 등록 기능 추가

|회원 리스트|회원 등록|회원 디테일|
|--------------|-------------|-------------|
|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/04397a79-e85a-4e6b-be7a-bfdf0a39d270">|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/1f6a821e-846b-44e9-a274-587f905da410">|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/300aa6b3-b808-42fe-91d3-61ed9b72ad2c">

### [강사관리]
- 강사 CRUD 구현
- 강사 등록 시 각 강사마다 고유코드 부여

|강사 리스트|강사 등록|강사 디테일|
|--------------|-------------|-------------|
|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/85a24e72-1ea3-41dc-8104-481630f994c2">|<img width="454" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/0e4adcf9-6837-4488-b9eb-9d278066afd3">|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/861fa1b2-90eb-4ee8-8198-32f063c7de4c">

### [수업 / 일정관리]
- 수업, 일정 CRUD 구현
- 날짜를 클릭하면 오른쪽에 간단한 디테일 화면 구현
- 오른쪽의 디테일을 클릭하면 자세한 리스트 확인 가능

|수업/일정 초기화면|수업/일정 추가|날짜 클릭 시 디테일|
|--------------|-------------|-------------|
|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/41e364cc-9f62-4111-b2c1-909b3d0e16af">|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/717f0351-d73f-4424-b9c2-4c810b406b1b">|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/e7a74c99-9397-49f3-a998-c30ce1703c20">

### [매출관리]
- 기간, 회원, 회원권 기준으로 매출을 확인 할 수 있음
- 리스트 클릭 시 모달로 디테일 구현

|매출 리스트|매출 디테일|
|--------------|-------------|
|<img width="649" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/79f77648-d91f-4023-8867-7ad6cf967c75">|<img width="649" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/26a56577-c096-4555-9ad8-87613690decf">

### [공지사항]
- 공지사항 CRUD 구현
- 회원들에게 전달 할 공지사항 공간
- 리스트 클릭 시 모달로 디테일 구현

|매출 리스트|매출 디테일|
|--------------|-------------|
|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/7fa5e9da-b5be-4c03-bf10-2d5bedba5013">|<img width="453" alt="image" src="https://github.com/yangtory/2024-Team-Mem/assets/151486114/fb6cc45c-cb46-4610-b6e6-2e015cfd5bb7">


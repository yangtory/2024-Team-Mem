<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
<link rel="stylesheet" href="${rootPath}/static/css/welcome.css" />
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
    AOS.init({ duration: 1200 }); // 자바스크립트로 init()을 해야 동작한다.
</script>

<div class="welcome_wrap">
    <div data-aos="fade-up" class="welcome1">
        <img src="${rootPath }/static/images/bug.png" width="200px" />
        <h1 class="title">환영합니다</h1>
        <p>맴맴은 처음이신가요?</p>
        <a class="button_price" href="${rootPath}/main/join">무료로 시작하기</a>
        <img class="angle_down" src="${rootPath }/static/images/down.png" width="20px" />
    </div>
    <section data-aos="fade-up" class="div_box">
        <div data-aos="fade-up">
            <h1>
                MemMem 을 소개합니다 <br />
                쉽게 회원관리를 시작해보세요
            </h1>
        </div>
    </section>

    <section data-aos="fade-up" class="div_box">
        <div data-aos="fade-up">
            <img src="${rootPath }/static/images/2.png" width="400px" />
        </div>
        <div data-aos="fade-up">
            <h1>간편한 회원권 관리</h1>
            <p>
                보다 쉬운 회원권 관리를 통해 <br />
                센터를 효율적으로 관리하여 회원들에게 원활한 서비스를 제공해 보세요!
            </p>
        </div>
    </section>

    <section data-aos="fade-up" class="div_box">
        <div data-aos="fade-up">
            <img src="${rootPath }/static/images/6.png" width="400px" />
        </div>
        <div data-aos="fade-up">
            <h1>편리한 회원관리</h1>
            <p>
                회원관리 기능을 통해 회원들의 정보 수정 등을 관리할 수 있습니다. <br />회원들과의 소통을 원활하게
                유지하고 <br />회원들의 활동을 모니터링하여 필요한 조치를 취할 수 있습니다.
            </p>
        </div>
    </section>

    <section data-aos="fade-up" class="div_box">
        <div data-aos="fade-up">
            <img src="${rootPath }/static/images/4.png" width="400px" />
        </div>
        <div data-aos="fade-up">
            <h1>강사관리 한눈에 보기</h1>
            <p>
                강사관리 기능을 통해 강사들의 정보를 관리하고 강의 일정을 관리할 수 있습니다. <br />
                강사들의 일정을 조율하여 수업을 효율적으로 운영하고 회원들에게 최상의 강의를 제공할 수 있습니다.
            </p>
        </div>
    </section>

    <section data-aos="fade-up" class="div_box">
        <div data-aos="fade-up">
            <img src="${rootPath }/static/images/5.png" width="400px" />
        </div>
        <div data-aos="fade-up">
            <h1>간편한 일정관리</h1>
            <p>
                일정관리 기능을 통해 수업 일정을 효율적으로 관리할 수 있습니다. <br />
                각 수업의 일정을 등록하고 수정하여 회원들에게 정확한 정보를 제공할 수 있습니다. <br />또한 강사들과의
                일정을 조율하여 강의를 원할하게 운영할 수 있습니다.
            </p>
        </div>
    </section>

    <section data-aos="fade-up" class="div_box">
        <div data-aos="fade-up">
            <img src="${rootPath }/static/images/7.png" width="400px" />
        </div>
        <div data-aos="fade-up">
            <h1>꼼꼼하게 수업관리하기!</h1>
            <p>
                수업관리 기능을 통해 다양한 수업을 제공하고 관리할 수 있습니다. <br />수업의 종류, 시간, 장소 등을
                등록하고 회원들이 수업을 예약할 수 있도록 합니다. <br />
                또한 수업에 대한 평가를 수집하여 서비스의 품질을 지속적으로 개선합니다.
            </p>
        </div>
    </section>

    <section data-aos="fade-up" class="div_box">
        <div data-aos="fade-up">
            <img src="${rootPath }/static/images/8.png" width="400px" />
        </div>
        <div data-aos="fade-up">
            <h1>공지사항 관리</h1>
            <p>
                공지사항 관리 기능을 통해 회원들에게 필요한 정보를 공지할 수 있습니다. <br />
                다양한 공지사항을 등록하고 회원들에게 효율적으로 알림을 전달할 수 있습니다. <br />
                또한 회원들의 의견을 수렴하여 서비스에 대한 정보를 제공합니다.
            </p>
        </div>
    </section>
    <footer>
        <address></address>
    </footer>
</div>

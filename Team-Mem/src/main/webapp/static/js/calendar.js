document.addEventListener("DOMContentLoaded", async () => {
  let date = new Date();
  let viewYear = date.getFullYear();
  let viewMonth = date.getMonth();
  const clickDates = document.querySelector("section");

  const renderCalender = async () => {
    viewYear = date.getFullYear();
    viewMonth = date.getMonth();
    document.querySelector(
      ".year-month"
    ).textContent = `${viewYear}년 ${viewMonth + 1}월`;
    const prevLast = new Date(viewYear, viewMonth, 0);
    const thisLast = new Date(viewYear, viewMonth + 1, 0);

    const PLDate = prevLast.getDate();
    const PLDay = prevLast.getDay();

    const TLDate = thisLast.getDate();
    const TLDay = thisLast.getDay();

    const prevDates = [];
    const thisDates = [...Array(TLDate + 1).keys()].slice(1);
    const nextDates = [];

    if (PLDay !== 6) {
      for (let i = 0; i < PLDay + 1; i++) {
        prevDates.unshift(PLDate - i);
      }
    }

    for (let i = 1; i < 7 - TLDay; i++) {
      nextDates.push(i);
    }
    const dates = prevDates.concat(thisDates, nextDates);
    const firstDateIndex = dates.indexOf(1);
    const lastDateIndex = dates.lastIndexOf(TLDate);

    dates.forEach((date, i) => {
      const condition =
        i >= firstDateIndex && i < lastDateIndex + 1
          ? "this"
          : "other";

      dates[
        i
      ] = `<div class="date"><div class=${condition}>${date}</div></div>`;
    });
    document.querySelector(".dates").innerHTML = dates.join("");

    const today = new Date();
    if (
      viewMonth === today.getMonth() &&
      viewYear === today.getFullYear()
    ) {
      for (let date of document.querySelectorAll(".this")) {
        if (+date.innerText === today.getDate()) {
          date.classList.add("today");

          break;
        }
      }
    }
  };

  const renderCalendar = async () => {
    // 캘린더 렌더링 코드
    const year_Text = String(viewYear);
    let month_text = String(viewMonth + 1);

    // 데이터 가져오기
    const res = await fetch(`${rootPath}/schedule/get`);
    const json = await res.json();

    const day_all = document.querySelectorAll(".this");
    const right = document.querySelector(".right");
    right.innerHTML = "";
    for (let j = 0; j < day_all.length; j++) {
      if (day_all[j].innerHTML.length === 1) {
        day_all[j].innerHTML = "0" + day_all[j].innerHTML;
      }
      const currentDate = new Date(
        `${year_Text}-${month_text}-${day_all[j].innerHTML}`
      );
      const formattedDate = formatDate(currentDate);

      // 해당 날짜에 속하는 일정들을 가져옴
      const schedules = json.filter(
        (schedule) =>
          schedule.s_sdate <= formattedDate &&
          schedule.s_edate >= formattedDate
      );

      if (schedules.length > 0) {
        // 이미 제목이 표시된 날짜인지 확인
        const existingTitleContainer = day_all[j].nextElementSibling;
        if (
          !existingTitleContainer ||
          !existingTitleContainer.classList.contains(
            "title-container"
          )
        ) {
          // 새로운 제목 컨테이너를 생성하여 해당 날짜 바로 다음에 삽입
          const titleContainer = document.createElement("span");
          titleContainer.classList.add("title-container");
          day_all[j].insertAdjacentElement(
            "afterend",
            titleContainer
          );

          schedules.forEach((schedule) => {
            // 해당 일정 추가
            const titleSpan = document.createElement("span");
            const rightSpan = document.createElement("div");
            const rightSpanTitle = document.createElement("article");
            titleSpan.textContent = schedule.s_title;
            const scheduleText = `${
              schedule.s_sdate + " ~ " + schedule.s_edate
            }`;
            const scheduleContent = `${schedule.s_title}`;
            titleSpan.classList.add("title");
            titleSpan.style.backgroundColor = schedule.s_color;
            if (schedule.s_color === "#ffffff") {
              titleSpan.style.color = "black";
            }

            if (!right.innerHTML.includes(scheduleText)) {
              rightSpan.textContent = scheduleText;
              rightSpanTitle.textContent = scheduleContent;

              rightSpan.classList.add("title");
              rightSpanTitle.classList.add("content");

              right.appendChild(rightSpan);

              rightSpan.appendChild(rightSpanTitle);
            }

            titleContainer.appendChild(titleSpan);
            rightSpan.setAttribute("data-sdate", schedule.s_sdate);
          });
        }
      }
    }
  };

  // 날짜를 YYYY-MM-DD 형식의 문자열로 변환하는 함수
  const formatDate = (date) => {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, "0");
    const day = String(date.getDate()).padStart(2, "0");
    return `${year}-${month}-${day}`;
  };
  const prevMonth = () => {
    date.setMonth(date.getMonth() - 1);
    viewYear = date.getFullYear(); // 변경된 viewYear 값 저장
    viewMonth = date.getMonth(); // 변경된 viewMonth 값 저장

    renderCalender();
  };

  const nextMonth = () => {
    date.setMonth(date.getMonth() + 1);
    viewYear = date.getFullYear(); // 변경된 viewYear 값 저장
    viewMonth = date.getMonth(); // 변경된 viewMonth 값 저장

    renderCalender();
  };

  const goToday = () => {
    date = new Date();
    viewYear = date.getFullYear(); // 변경된 viewYear 값 저장
    viewMonth = date.getMonth(); // 변경된 viewMonth 값 저장

    renderCalender();
  };

  prevMonth();
  nextMonth();
  goToday();

  const prevBtn = document.querySelector("button.go-prev");
  const goBtn = document.querySelector("button.go-today");
  const nextBtn = document.querySelector("button.go-next");

  prevBtn?.addEventListener("click", () => {
    prevMonth();
    renderCalendar();
  });

  goBtn?.addEventListener("click", () => {
    goToday();
    renderCalendar();
  });
  nextBtn?.addEventListener("click", () => {
    nextMonth();
    renderCalendar();
  });

  for (let j = 0; j < viewMonth.length; j++) {
    if (viewMonth[j].length === 1) {
      viewMonth[j].innerHTML = "0" + viewMonth.innerHTML;
    }
  }

  clickDates?.addEventListener("click", async (e) => {
    const target = e.target;

    let viewMonthStr = String(viewMonth + 1);
    if (viewMonthStr.length === 1) {
      viewMonthStr = "0" + viewMonthStr;
    }

    if (
      target.tagName === "SPAN" ||
      target.classList.contains("date")
    ) {
      const click = target.closest("DIV").innerText[0];
      const click2 = target.closest("DIV").innerText[1];
      const dates = `${viewYear}-${viewMonthStr}-${click}${click2}`;
      document.location.href = `${rootPath}/schedule/detail/${dates}`;
    }
  });
  const right_box = document.querySelector("aside.right");
  right_box.addEventListener("click", (e) => {
    const target = e.target;
    if (
      target.classList.contains("content") ||
      target.tagName === "DIV"
    ) {
      const sdate = target.closest("div").dataset.sdate;
      document.location.href = `${rootPath}/schedule/detail/${sdate}`;
    }
  });

  // // 캘린더 초기화
  renderCalendar();
});

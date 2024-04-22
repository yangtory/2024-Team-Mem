document.addEventListener("DOMContentLoaded", async () => {
  let date = new Date();
  let viewYear = date.getFullYear();
  let viewMonth = date.getMonth();
  const clickDates = document.querySelector(".dates");
  const renderCalender = async () => {
    viewYear = date.getFullYear();
    viewMonth = date.getMonth();
    document.querySelector(".year-month").textContent = `${viewYear}년 ${viewMonth + 1}월`;
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
      const condition = i >= firstDateIndex && i < lastDateIndex + 1 ? "this" : "other";

      dates[i] = `<div class="date"><span class=${condition}>${date}</span></div>`;
    });
    document.querySelector(".dates").innerHTML = dates.join("");

    const today = new Date();
    if (viewMonth === today.getMonth() && viewYear === today.getFullYear()) {
      for (let date of document.querySelectorAll(".this")) {
        if (+date.innerText === today.getDate()) {
          date.classList.add("today");
          break;
        }
      }
    }

    clickDates?.addEventListener("click", async (e) => {
      const date = e.target.innerText;

      const dates = `${viewYear}-${viewMonth + 1}-${date}`;
      // console.log(dates);
      // alert(`${viewYear}-${viewMonth}-${date}`);
      if (date) {
        // document.location.href = `${rootPath}/schedule/insert/${dates}`;
      }
      // res = await fetch(`${rootPath}/schedule/get/${dates}`);
      // json = await res.text();
      // if (json === dates) {
      // const date = document.querySelector(".dates");
      // date.style.color = "white";
      // dateElement.style.color = "white";
      // renderCalender();
      // console.log(json);
      // }
    });
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

  renderCalender();
  prevMonth();
  nextMonth();
  goToday();
  const prevBtn = document.querySelector("button.go-prev");
  const goBtn = document.querySelector("button.go-today");
  const nextBtn = document.querySelector("button.go-next");

  prevBtn?.addEventListener("click", () => {
    prevMonth();
  });

  goBtn?.addEventListener("click", () => {
    goToday();
  });
  nextBtn?.addEventListener("click", () => {
    nextMonth();
  });
  clickDates?.addEventListener("click", async (e) => {
    const date = e.target.innerText;

    //   console.log(date);
    const dates = `${viewYear}-${viewMonth + 1}-${date}`;
    //   // alert(`${viewYear}-${viewMonth}-${date}`);
    if (date) {
      document.location.href = `${rootPath}/schedule/insert/${dates}`;
    }
    //   const res = await fetch(`${rootPath}/schedule/get/${dates}`);
    //   const json = await res.text();
    //   console.log(json);
  });

  // try {
  //   const res = await fetch(`${rootPath}/schedule/get`);
  //   const json = res.json();
  //   console.log(json);
  //   return json === "OK";
  // } catch (error) {
  //   alert("서버와 통신오류");
  // }
  // 캘린더 렌더링 함수
  const renderCalendar = async () => {
    // 캘린더 렌더링 코드
    const year_Text = String(viewYear);
    let month_text = String(viewMonth);

    // 데이터 가져오기
    const res = await fetch(`${rootPath}/schedule/get`);
    const json = await res.json();
    console.log(json);
    const ex = new Array();

    if (json.length !== 0) {
      for (let i = 0; i < json.length; i++) {
        ex.push(json[i].s_sdate);
      }
    }
    console.log(ex);
    const day_all = document.querySelectorAll("div.dates");
    console.log(day_all.length);
    for (let i = 0; i < ex.length; i++) {
      if (month_text.length === 1) {
        month_text = "0" + month_text;
        console.log(month_text);
      }

      for (let j = 0; j < day_all.length; j++) {
        if (day_all[j].length === 1) {
          day_all[j] = "0" + day_all[j];
        }
        if (`${year_Text}-${month_text}-${day_all[j]}` === ex[i]) {
          day_all[j].classList.add("product");
        }
      }
    }

    // 가져온 데이터를 캘린더에 표시
    // data.forEach((schedule) => {
    //     const startDate = new Date(schedule.s_sdate); // 시작날짜
    //     const endDate = new Date(schedule.s_edate); // 마무리날짜
    //     console.log(startDate);

    //     // 시작날짜부터 마무리날짜까지의 범위에 해당하는 셀에 클래스 추가
    //     for (let d = new Date(startDate); d <= endDate; d.setDate(d.getDate() + 1)) {
    //       const year = d.getFullYear();
    //       const month = d.getMonth() + 1; // 월은 0부터 시작하므로 +1 해줌
    //       const day = d.getDate();

    //       // 해당 날짜의 셀을 찾아 클래스 추가
    //       const cell = document.querySelector(`.dates[data-year="${year}"][data-month="${month}"][data-day="${day}"]`);
    //       if (cell) {
    //         cell.classList.add("scheduled");
    //       }
    //     }
    //   });
  };

  // // 캘린더 초기화
  renderCalendar();
});

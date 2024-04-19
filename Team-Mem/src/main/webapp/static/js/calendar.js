let date = new Date();
const viewYear = date.getFullYear();
const viewMonth = date.getMonth();
const renderCalender = () => {
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
};

const prevMonth = () => {
  date.setMonth(date.getMonth() - 1);
  renderCalender();
};
const nextMonth = () => {
  date.setMonth(date.getMonth() + 1);
  renderCalender();
};
const goToday = () => {
  date = new Date();
  renderCalender();
};

document.addEventListener("DOMContentLoaded", () => {
  renderCalender();
  prevMonth();
  nextMonth();
  goToday();
  const prevBtn = document.querySelector("button.go-prev");
  const goBtn = document.querySelector("button.go-today");
  const nextBtn = document.querySelector("button.go-next");

  const dates = document.querySelector(".dates");

  prevBtn?.addEventListener("click", () => {
    prevMonth();
  });

  goBtn?.addEventListener("click", () => {
    goToday();
  });
  nextBtn?.addEventListener("click", () => {
    nextMonth();
  });
  dates.addEventListener("click", async (e) => {
    const click = e.target.innerText;
    // alert(click);
    if (click) {
      // document.location.href = `${rootPath}/schedule/insert/${viewYear}${viewMonth}${click}`;
      // document.location.href = `${rootPath}/schedule/insert`;
    }
    const res = await fetch(`1`);
    const json = await res.json();
    console.log(json);
  });
});

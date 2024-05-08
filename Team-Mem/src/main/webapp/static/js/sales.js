document.addEventListener("DOMContentLoaded", () => {
  const prices = document.querySelectorAll("td.price");
  let sum = 0;

  // 각 가격을 합산
  prices.forEach((price) => {
    sum += parseFloat(price.textContent.replace(/[^0-9.-]+/g, "")); // 가격에서 숫자만 추출하여 합산
  });

  // 합산된 총 매출을 출력
  const total = document.querySelector("td.total");
  total.textContent = sum.toLocaleString("ko-KR");

  const search_btn = document.querySelector("button.button-32");
  const search_form = document.querySelector("form.search_form");
  const sdate = document.querySelector("input.sdate");
  const edate = document.querySelector("input.edate");

  search_btn.addEventListener("click", () => {
    if (sdate.value != null && !edate.value) {
      alert("종료일을 선택해주세요");
      edate.select();
      return false;
    }
    if (edate.value != null && !sdate.value) {
      alert("시작일을 선택해주세요");
      sdate.select();
      return false;
    }
    search_form.submit();
  });
});

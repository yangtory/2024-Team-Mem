document.addEventListener("DOMContentLoaded", async () => {
  const res = await fetch(`${rootPath}/main/total`);
  const json = await res.json();
  // console.log(json);

  const response = await fetch(`${rootPath}/main/MonthTotal`);
  const resjson = await response.json();

  var ctx = document.getElementById("myPieChart").getContext("2d");

  const jsonArray = resjson.map((item) => {
    if (item !== null && typeof item === "object" && "total_price" in item) {
      return { total_price: item.total_price };
    } else {
      return null;
    }
  });
  const jsonString = JSON.stringify(jsonArray);
  console.log(jsonString);
  // 그래프 데이터
  const data = {
    labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
    datasets: [
      {
        label: "월별 매출액",
        data: resjson.map((item) => (item ? item.total_price : 0)), // 각 요소가 객체 형식으로 변환되었는지 확인 후, total_price를 사용하거나 0을 사용합니다.
        backgroundColor: "#FF6384",
      },
    ],
  };

  // 그래프 생성

  var myPieChart = new Chart(ctx, {
    type: "bar",
    data: data,
  });
});

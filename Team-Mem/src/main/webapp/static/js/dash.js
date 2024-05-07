document.addEventListener("DOMContentLoaded", async () => {
  const res = await fetch(`${rootPath}/main/total`);
  const json = await res.json();
  const notice = document.querySelector("div.table_div");
  notice.addEventListener("click", () => {
    document.location.href = `${rootPath}/notice`;
  });

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

  const result = await fetch(`${rootPath}/main/user`);
  const resultjson = await result.json();
  console.log(resultjson);

  const monthlyUsers = new Array(12).fill(0);

  resultjson.forEach((item) => {
    if (item && item.us_date) {
      const date = new Date(item.us_date);
      const month = date.getMonth() + 1;
      const formattedDate = `2024-${month < 10 ? "0" + month : month}`;
      console.log(formattedDate);
      const monthIndex = month - 1;
      monthlyUsers[monthIndex]++;
    }
  });

  const data2 = {
    labels: ["2024-01", "2024-02", "2024-03", "2024-04", "2024-05", "2024-06", "2024-07", "2024-08", "2024-09", "2024-10", "2024-11", "2024-12"],
    datasets: [
      {
        label: "월별 유저가입수",
        data: resultjson,
        backgroundColor: "#6acd95",
      },
    ],
  };

  const options = {
    scales: {
      y: {
        ticks: {
          stepSize: 1, // Y축의 간격을 1로 설정
        },
      },
    },
  };
  // 그래프 초기화 함수
  function drawChart(data) {
    var ctx2 = document.getElementById("myUserChart").getContext("2d");
    var myPieChart2 = new Chart(ctx2, {
      type: "bar",
      data: data,
      options: options,
    });
  }

  // 그래프 그리기
  drawChart(data2);
});

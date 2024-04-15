document.addEventListener("DOMContentLoaded", () => {
  const table = document.querySelector("table.teacher.list");

  table.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const code = target.closest("TR").dataset.code;
      //   alert(code);
      document.location.href = `${rootPath}/teacher/detail/${code}`;
    }
  });
});

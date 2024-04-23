document.addEventListener("DOMContentLoaded", () => {
  const list = document.querySelector("table.notice.list");

  list.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const seq = target.closest("TR").dataset.seq;
      //   alert(seq);
      document.location.href = `${rootPath}/notice/detail/${seq}`;
    }
  });
});

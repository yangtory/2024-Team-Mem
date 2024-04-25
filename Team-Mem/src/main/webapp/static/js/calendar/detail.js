document?.addEventListener("DOMContentLoaded", () => {
  const body = document.querySelector("tbody.body");
  const delBtn = document.querySelector("button.delete");
  body?.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const seq = target.closest("TR").dataset.id;
      document.location.href = `${rootPath}/schedule/update/${seq}`;
    }
  });
  delBtn.addEventListener("click", (e) => {
    const seq = e.target.dataset.seq;
    document.location.href = `${rootPath}/schedule/delete/${seq}`;
  });
});

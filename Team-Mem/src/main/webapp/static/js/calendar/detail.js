document.addEventListener("DOMContentLoaded", () => {
  const body = document.querySelector("tbody.body");

  body.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const seq = target.closest("TR").dataset.id;
      document.location.href = `${rootPath}/schedule/update/${seq}`;
    }
  });
});

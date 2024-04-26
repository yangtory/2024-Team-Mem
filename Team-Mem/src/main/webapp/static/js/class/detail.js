document.addEventListener("DOMContentLoaded", () => {
  const body = document.querySelector("tbody.body");

  body.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const seq = target.closest("TR").dataset.seq;

      document.location.href = `${rootPath}/class/update/${seq}`;
    }
  });
});

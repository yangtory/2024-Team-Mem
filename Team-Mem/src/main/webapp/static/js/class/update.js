document.addEventListener("DOMContentLoaded", () => {
  const delBtn = document.querySelector("button[type='button']");

  delBtn.addEventListener("click", (e) => {
    const target = e.target.dataset.seq;
    document.location.href = `${rootPath}/class/delete/${target}`;
  });
});

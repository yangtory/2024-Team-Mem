document?.addEventListener("DOMContentLoaded", () => {
  const body = document.querySelector("tbody.body");
  const delBtn = document.querySelector("input.delete");
  const color_box = document.querySelector("div.palette");
  const selectedColor = document.querySelector("#colorPicker");
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
  color_box.addEventListener("click", (e) => {
    const target = e.target;
    const colors = document.querySelectorAll(".palette .color");
    colors.forEach((color) => {
      color.style.border = "none";
    });
    if (target.classList.contains("color")) {
      target.style.border = "1px solid white";
    }

    if (target.classList.contains("color1")) {
      selectedColor.value = "#fcd8c9";
      return false;
    }
    if (target.classList.contains("color2")) {
      selectedColor.value = "#e3ebd9";
      return false;
    }
    if (target.classList.contains("color3")) {
      selectedColor.value = "#f4d1db";
      return false;
    }
    if (target.classList.contains("color4")) {
      selectedColor.value = "#cbcedc";
      return false;
    }
    if (target.classList.contains("color5")) {
      selectedColor.value = "#f7c8cb";
      return false;
    }
    if (target.classList.contains("color6")) {
      selectedColor.value = "#b6c7cf";
      return false;
    }
    if (target.classList.contains("color7")) {
      selectedColor.value = "#f3d0cd";
      return false;
    }
    if (target.classList.contains("color8")) {
      selectedColor.value = "#c8d8b4";
      return false;
    }
  });
});

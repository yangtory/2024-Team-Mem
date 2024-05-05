document?.addEventListener("DOMContentLoaded", () => {
  const input_box = document?.querySelector("form.input_box");
  const title = input_box?.querySelector("input[name='s_title']");
  const content = input_box?.querySelector("input[name='s_content']");
  const startDate = input_box?.querySelector("input[name='s_sdate']");
  const endDate = input_box?.querySelector("input[name='s_edate']");
  const selectedColor = input_box?.querySelector("#colorPicker");
  const button = input_box?.querySelector("input[type='button']");
  const error = document?.querySelector("div.class.error");
  const color_box = document?.querySelector("div.palette");
  button?.addEventListener("click", () => {
    error.innerHTML = "";

    if (!title.value) {
      error.innerHTML = "제목을 입력해주세요";
      title.select();
      return false;
    }
    if (!content.value) {
      error.innerHTML = "내용을 입력해주세요";
      content.select();
      return false;
    }
    if (selectedColor.value == "#ffffff") {
      error.innerHTML = "색상을 선택해주세요";
      selectedColor.select();
      return false;
    }
    if (!endDate.value) {
      if (confirm("종료일자를 입력하지않으면 시작일자로 맞춰집니다. 그대로 진행할까요?")) {
        endDate.value = startDate.value;
        input_box.submit();
      } else {
        error.innerHTML = "종료일자를 입력하세요";
        endDate.select();
        return false;
      }
    }
    input_box.submit();
  });
  color_box?.addEventListener("click", (e) => {
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
      selectedColor.value = "#ef9297";
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

document.addEventListener("DOMContentLoaded", () => {
  const input_box = document?.querySelector("form.input_box");
  const title = input_box?.querySelector("input[name='c_name']");
  const teacher = input_box?.querySelector("select[name='c_tcode']");
  const startbtn = input_box?.querySelector("input[name='c_sdate']");
  const endbtn = input_box?.querySelector("input[name='c_edate']");
  const startTime = input_box?.querySelector("input[name='c_stime']");
  const endTime = input_box?.querySelector("input[name='c_etime']");
  const button = input_box?.querySelector("input[type='button']");
  const class_error = document?.querySelector("div.class.error");
  const color_box = document?.querySelector("div.palette");
  const selectedColor = input_box?.querySelector(".colorPicker");
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
  button?.addEventListener("click", () => {
    class_error.innerHTML = "";

    if (!title.value) {
      class_error.innerHTML = "수업명을 입력해주세요";
      title.select();
      return false;
    }
    if (!teacher.value) {
      class_error.innerHTML = "강사를 선택해주세요";
      teacher.select();
      return false;
    }

    if (selectedColor.value == "#ffffff") {
      class_error.innerHTML = "색상을 선택해주세요";
      selectedColor.select();
      return false;
    }
    if (!endbtn.value) {
      if (confirm("종료일자를 입력하지않으면 개강일자로 맞춰집니다. 그대로 진행할까요?")) {
        endbtn.value = startbtn.value;

        return false;
      } else {
        class_error.innerHTML = "종료일자를 입력하세요";
        endbtn.select();
        return false;
      }
    }
    if (!startTime.value) {
      class_error.innerHTML = "시작시간을 입력해주세요";
      startTime.select();
      return false;
    }
    if (!endTime.value) {
      class_error.innerHTML = "종료시간을 입력해주세요";
      endTime.select();
      return false;
    }

    input_box.submit();
  });
});

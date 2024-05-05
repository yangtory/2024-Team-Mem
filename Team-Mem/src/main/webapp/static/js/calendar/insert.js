document?.addEventListener("DOMContentLoaded", () => {
  const input_box = document.querySelector("form.input_box");
  const title = input_box.querySelector("input[name='s_title']");
  const content = input_box.querySelector("input[name='s_content']");
  const startDate = input_box.querySelector("input[name='s_sdate']");
  const endDate = input_box.querySelector("input[name='s_edate']");
  const selectedColor = input_box.querySelector("#colorPicker");
  const button = input_box.querySelector("button[type='button']");
  const error = document?.querySelector("div.class.error");
  const color_box = document.querySelector("div.palette");
  button.addEventListener("click", () => {
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
  color_box.addEventListener("click", (e) => {
    const target = e.target;
    if (target.classList.contains("color1")) {
      alert("나는 color1");
    }
  });
});

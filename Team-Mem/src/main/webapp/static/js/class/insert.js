document.addEventListener("DOMContentLoaded", () => {
  const input_box = document.querySelector("form.input.form");
  const title = input_box.querySelector("input[name='c_name']");
  const teacher = input_box.querySelector("select[name='c_tcode']");
  const startbtn = input_box.querySelector("input[name='c_sdate']");
  const endbtn = input_box.querySelector("input[name='c_edate']");
  const button = input_box.querySelector("button[type='button']");
  const class_error = document.querySelector("div.class.error");
  button.addEventListener("click", (e) => {
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
    if (!endbtn.value) {
      if (confirm("종강일자를 입력하지않으면 개강일자로 맞춰집니다. 그대로 진행할까요?")) {
        endbtn.value = startbtn.value;
        input_box.submit();
      } else {
        class_error.innerHTML = "종강일자를 입력하세요";
        endbtn.select();
        return false;
      }
    }
    input_box.submit();
  });
});

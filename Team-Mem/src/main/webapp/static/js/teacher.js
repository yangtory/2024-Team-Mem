document.addEventListener("DOMContentLoaded", () => {
  const table = document.querySelector("table.teacher.list");
  const input_btn = document.querySelector("button.teacher.input");

  table?.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const code = target.closest("TR").dataset.code;
      //   alert(code);
      document.location.href = `${rootPath}/teacher/detail/${code}`;
    }
  });
  input_btn?.addEventListener("click", () => {
    document.location.href = `${rootPath}/teacher/insert`;
  });

  const input_form = document.querySelector("form.teacher.input_box");
  const tname = input_form?.querySelector("input[name='t_name']");
  const ttel = input_form?.querySelector("input[name='t_tel']");
  const input_form_btn = input_form?.querySelector("input.insert");
  const teacher_error = document.querySelector("div.teacher.error");

  input_form_btn?.addEventListener("click", () => {
    teacher_error.innerHTML = "";
    if (!tname.value) {
      teacher_error.innerHTML = "강사 이름는 반드시 입력해주세요";
      tname.select();
      return false;
    }
    if (!ttel.value) {
      teacher_error.innerHTML = "전화번호는 반드시 입력해주세요";
      ttel.select();
      return false;
    }
    input_form.submit();
  });
});

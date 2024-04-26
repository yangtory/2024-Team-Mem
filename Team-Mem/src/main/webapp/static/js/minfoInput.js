document.addEventListener("DOMContentLoaded", () => {
  const form_minfo = document.querySelector("fieldset.form.minfo");

  const select = form_minfo.querySelector("select");
  const option = form_minfo.querySelector("option");

  // 회원권 정보 가져오기
  const getMinfo = async (seq) => {
    const res = await fetch(`${rootPath}/customer/getminfo/${seq}`);
    const json = res.json();
    console.log(json);
  };

  select.addEventListener("change", () => {
    const selectedValue = select.value;
    getMinfo(selectedValue);

    // alert(selectedValue);
  });
});

document.addEventListener("DOMContentLoaded", () => {
  const form_minfo = document.querySelector("fieldset.form.minfo");

  const select = form_minfo.querySelector("select");
  const icount = form_minfo.querySelector("input.r_icount");

  // 회원권 정보 가져오기
  const getMinfo = async (seq) => {
    const res = await fetch(`${rootPath}/customer/getminfo/${seq}`);
    const json = await res.json();
    console.log(json);
    icount.value = json.i_count;
  };

  select.addEventListener("change", () => {
    const selectedValue = select.value;
    getMinfo(selectedValue);

    // alert(selectedValue);
  });
});
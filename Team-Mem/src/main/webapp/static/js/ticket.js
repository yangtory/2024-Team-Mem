document.addEventListener("DOMContentLoaded", () => {
  const table = document.querySelector("table.ticket.list");

  const ticket_form = document.querySelector("form.ticket.input_box");
  const title = ticket_form?.querySelector("input[name='i_title']");
  const count = ticket_form?.querySelector("input[name='i_count']");
  const price = ticket_form?.querySelector("input[name='i_price']");
  const ticket_btn = ticket_form?.querySelector("input.insert");
  const ticket_error = document.querySelector("div.ticket.error");

  table?.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const seq = target.closest("TR").dataset.seq;
      // alert(seq);
      document.location.href = `${rootPath}/ticket/detail/${seq}`;
    }
  });

  ticket_btn?.addEventListener("click", () => {
    ticket_error.innerHTML = "";
    if (!title.value) {
      ticket_error.innerHTML = "제목을 입력해주세요";
      title.select();
      return false;
    }
    if (!count.value) {
      ticket_error.innerHTML = "수강 횟수를 입력해주세요";
      count.select();
      return false;
    }
    if (!price.value) {
      ticket_error.innerHTML = "수강권 가격을 입력해주세요";
      price.select();
      return false;
    }
    ticket_form.submit();
  });
});

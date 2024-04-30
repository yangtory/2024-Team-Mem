const addButton = document.querySelector("button[type='submit']");
addButton.addEventListener("click", async () => {
  const title = document.querySelector("input[name='s_title']").value;
  const content = document.querySelector("input[name='s_content']").value;
  const startDate = document.querySelector("input[name='s_sdate']").value;
  const endDate = document.querySelector("input[name='s_edate']").value;
  const selectedColor = document.querySelector("#colorPicker").value;

  const res = await fetch(`${rootPath}/schedule/color`);
  const json = await res.json();
  console.log(json);
});

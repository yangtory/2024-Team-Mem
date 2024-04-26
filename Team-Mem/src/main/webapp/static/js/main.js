document.addEventListener("DOMContentLoaded", () => {
  const side_nav = document.querySelector("div.side");

  const NAV = {
    회원권: { name: "회원권", url: "/ticket" },
    회원관리: { name: "회원관리", url: "/customer" },
    강사관리: { name: "강사관리", url: "/teacher" },
    수업관리: { name: "수업관리", url: "/class" },
    일정관리: { name: "일정관리", url: "/schedule" },
    공지사항: { name: "공지사항", url: "/notice" },
    설정: { name: "설정", url: "/setting" },
  };

  side_nav.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "LI") {
      const text = target.innerText;
      const url = NAV[text].url;
      document.location.href = `${rootPath}${url}`;
    }
  });
});

document.addEventListener('DOMContentLoaded', () => {
    const list = document.querySelector('table.notice.list');

    const notice_form = document.querySelector('form.notice.input_box');
    const title = notice_form?.querySelector("input[name='n_title']");
    const content = notice_form?.querySelector("textarea[name='n_content']");
    const notice_btn = notice_form?.querySelector('input.insert');

    list?.addEventListener('click', (e) => {
        const target = e.target;
        if (target.tagName === 'TD') {
            const seq = target.closest('TR').dataset.seq;
            //   alert(seq);
            document.location.href = `${rootPath}/notice/detail/${seq}`;
        }
    });

    notice_btn?.addEventListener('click', () => {
        if (!title.value && !content.value) {
            if (confirm('제목과 내용이 없습니다. 그대로 등록할까요?')) {
                title.value = '제목없음';
                content.value = '내용없음';
                notice_form.submit();
            } else {
                title.select();
                return false;
            }
        }
        if (!content.value) {
            if (confirm('내용이 없습니다. 그대로 등록할까요?')) {
                content.value = '내용없음';
                notice_form.submit();
            } else {
                content.select();
                return false;
            }
        }
        if (!title.value) {
            if (confirm('제목이 없습니다. 그대로 등록할까요?')) {
                title.value = '제목없음';
                notice_form.submit();
            } else {
                content.select();
                return false;
            }
        }
        notice_form.submit();
    });
});

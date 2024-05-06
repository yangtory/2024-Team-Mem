document.addEventListener('DOMContentLoaded', () => {
    const list = document.querySelector('table.notice.list');

    const notice_form = document.querySelector('form.notice.input_box');
    const title = notice_form?.querySelector("input[name='n_title']");
    const content = notice_form?.querySelector("textarea[name='n_content']");
    const notice_btn = notice_form?.querySelector('input.insert');

    // list?.addEventListener('click', (e) => {
    //     const target = e.target;
    //     if (target.tagName === 'TD') {
    //         const seq = target.closest('TR').dataset.seq;
    //         //   alert(seq);
    //         document.location.href = `${rootPath}/notice/detail/${seq}`;
    //     }
    // });

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

    const detailDiv = document.querySelector('div.detail');
    const modalBackdrop = document.querySelector('div.modal-backdrop');
    const notice_update = document.querySelector('button.notice_update');
    const notice_delete = document.querySelector('button.notice_delete');

    document.querySelectorAll('.table_div table tr').forEach((row) => {
        row.addEventListener('click', () => {
            const seq = row.getAttribute('data-seq');
            if (seq) {
                // 선택된 행이 있는 경우
                detailDiv.classList.add('show'); // 디테일 표시
                modalBackdrop.classList.add('show'); // 모달 배경 표시
                notice_update.setAttribute('href', `${rootPath}/notice/update/${seq}`);
                notice_delete.setAttribute('href', `${rootPath}/notice/delete/${seq}`);

                // 선택된 행의 데이터를 가져와서 입력 필드에 채움
                const title = row.querySelector('.title').textContent;
                const content = row.querySelector('.content').textContent;
                document.querySelector('input[name="title"]').value = title;
                document.querySelector('textarea[name="content"]').value = content;
            } else {
                // 선택된 행이 없는 경우
                detailDiv.classList.remove('show'); // 디테일 숨김
                modalBackdrop.classList.remove('show'); // 모달 배경 숨김
                notice_update.removeAttribute('href');
                notice_delete.removeAttribute('href');
            }
        });
    });

    // 모달을 닫는 버튼에 대한 클릭 이벤트 처리
    document.querySelector('.modal-backdrop').addEventListener('click', (e) => {
        const target = e.target;
        if (target !== detailDiv && !detailDiv.contains(target)) {
            detailDiv.classList.remove('show');
            document.querySelector('.modal-backdrop').classList.remove('show');
        }
    });

    // 수정 버튼 클릭 시 페이지 이동
    notice_update.addEventListener('click', (e) => {
        e.preventDefault();
        const seq = notice_update.getAttribute('href').split('/').pop();
        document.location.href = `${rootPath}/notice/update/${seq}`;
    });

    // 삭제 버튼 클릭 시 페이지 이동
    notice_delete.addEventListener('click', (e) => {
        e.preventDefault();
        const seq = notice_delete.getAttribute('href').split('/').pop();
        if (confirm('정말 삭제할까요?')) {
            document.location.href = `${rootPath}/notice/delete/${seq}`;
        }
    });
});

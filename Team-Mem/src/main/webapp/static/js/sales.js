document.addEventListener('DOMContentLoaded', () => {
    const prices = document.querySelectorAll('td.price');
    let sum = 0;

    // 각 가격을 합산
    prices.forEach((price) => {
        sum += parseFloat(price.textContent.replace(/[^0-9.-]+/g, '')); // 가격에서 숫자만 추출하여 합산
    });

    // 합산된 총 매출을 출력
    const total = document.querySelector('td.total');
    total.textContent = sum.toLocaleString('ko-KR');

    const search_btn = document.querySelector('button.button-32');
    const search_form = document.querySelector('form.search_form');
    const sdate = document.querySelector('input.sdate');
    const edate = document.querySelector('input.edate');

    search_btn?.addEventListener('click', () => {
        if (!sdate.value && edate.value) {
            alert('시작일을 선택해주세요');
            edate.select();
            return false;
        }
        if (!edate.value && sdate.value) {
            alert('종료일을 선택해주세요');
            sdate.select();
            return false;
        }
        search_form.submit();
    });

    const detailDiv = document.querySelector('div.detail');
    const modalBackdrop = document.querySelector('div.modal-backdrop');

    document.querySelectorAll('.table_div table tr.sales_list').forEach((row) => {
        row.addEventListener('click', () => {
            const sdate = row.getAttribute('data-sdate');
            const id = row.getAttribute('data-uid');

            if (sdate && id) {
                // 선택된 행이 있는 경우
                detailDiv.classList.add('show'); // 디테일 표시
                modalBackdrop.classList.add('show'); // 모달 배경 표시

                // 선택된 행의 데이터를 가져와서 입력 필드에 채움
                const sdate = row.querySelector('.sdate').textContent;
                const id = row.querySelector('.id').textContent;
                const title = row.querySelector('.title').textContent;
                const price = row.querySelector('.price').textContent;

                document.querySelector('input[name="r_sdate"]').value = sdate;
                document.querySelector('input[name="r_uid"]').value = id;
                document.querySelector('input[name="i_title"]').value = title;
                document.querySelector('input[name="i_price"]').value = price;
            } else {
                // 선택된 행이 없는 경우
                detailDiv.classList.remove('show'); // 디테일 숨김
                modalBackdrop.classList.remove('show'); // 모달 배경 숨김
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
});

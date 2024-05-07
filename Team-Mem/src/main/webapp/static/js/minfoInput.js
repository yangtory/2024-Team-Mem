document.addEventListener('DOMContentLoaded', () => {
    const user_form = document.querySelector('form.formBox');
    const selectBox = document.querySelector('div.selectBox');

    const select = selectBox.querySelector('select.select');
    const icount = document.querySelector('input.r_icount');
    const id = document.querySelector('input.us_uid');
    const sdate = document.querySelector('input.r_sdate');
    const edate = document.querySelector('input.r_edate');

    const user_btn = document.querySelector('input.insert');
    const m_error = document.querySelector('div.m_error');
    const u_error = document.querySelector('div.user_error');

    select?.addEventListener('change', async () => {
        const selectedValue = select.value;
        getMinfo(selectedValue);

        // alert(selectedValue);
    });

    user_btn?.addEventListener('click', async () => {
        m_error.innerHTML = '';
        u_error.innerHTML = '';

        const selectedValue = select.value;
        const idValue = id.value;
        const result = await checkMinfo(selectedValue, idValue);

        // 빈 칸 검사
        if (!id.value) {
            u_error.innerHTML = '회원을 선택해주세요';
            return false;
        }
        if (!select.value) {
            m_error.innerHTML = '수강권을 선택해주세요';
            return false;
        }
        if (!icount.value) {
            m_error.innerHTML = '수강권을 선택해주세요';
            return false;
        }
        if (!sdate.value) {
            m_error.innerHTML = '시작일을 선택해주세요';
            return false;
        }
        if (!edate.value) {
            m_error.innerHTML = '종료일을 선택해주세요';
            return false;
        }

        // 회원권 중복검사
        if (result !== '0') {
            m_error.innerHTML = '이미 등록된 회원권입니다 <br> 회원권 수정을 이용해주세요';
            return false;
        }
        // 종료일 유효성검사
        if (new Date(sdate.value) > new Date(edate.value)) {
            m_error.innerHTML = '종료일은 시작일의 이후로 지정해주세요';
            edate.select();
            return false;
        }
        user_form.submit();
    });

    // 회원이 가지고있는 회원권 중복 검사
    const checkMinfo = async (seq, id) => {
        const res = await fetch(`${rootPath}/customer/checkminfo/${id}/${seq}`);
        const json = await res.text();
        return json;
    };

    // 회원권 정보 가져오기
    const getMinfo = async (seq) => {
        const res = await fetch(`${rootPath}/customer/getminfo/${seq}`);
        const json = await res.json();
        console.log(json);
        icount.value = json.i_count;
    };
});

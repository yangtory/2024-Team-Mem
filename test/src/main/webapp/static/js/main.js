document.addEventListener('DOMContentLoaded', () => {
    const side_nav = document.querySelector('div.side');
    const login_form = document.querySelector('form.login');
    const join_form = document.querySelector('form.join');
    const join_btn = document.querySelector('button.join_btn');
    const login_btn = document.querySelector('button.login_btn');

    const error_box = document.querySelector('div.login.error');
    const error_box_join = document.querySelector('div.join.error');

    const NAV = {
        회원권: { name: '회원권', url: '/ticket' },
        회원관리: { name: '회원관리', url: '/customer' },
        강사관리: { name: '강사관리', url: '/teacher' },
        수업관리: { name: '수업관리', url: '/class' },
        일정관리: { name: '일정관리', url: '/schedule' },
        공지사항: { name: '공지사항', url: '/notice' },
    };

    side_nav.addEventListener('click', (e) => {
        const target = e.target;
        if (target.tagName === 'LI') {
            const text = target.innerText;
            const url = NAV[text].url;
            document.location.href = `${rootPath}${url}`;
        }
    });

    login_btn?.addEventListener('click', () => {
        const id = login_form.querySelector("input[name='u_id']");
        const password = login_form.querySelector("input[name='u_password']");

        error_box.innerHTML = '';
        if (!id.value) {
            error_box.innerHTML = '아이디를 입력하세요';
            id.select();
            return false;
        }
        if (!password.value) {
            error_box.innerHTML = '비밀번호를 입력하세요';
            password.select();
            return false;
        }
        login_form.submit();
    });

    join_btn?.addEventListener('click', async () => {
        const id = join_form.querySelector("input[name='u_id']");
        const pw = join_form.querySelector("input[name='u_password']");
        const name = join_form.querySelector("input[name='u_name']");
        const addr = join_form.querySelector("input[name='u_addr']");
        const tel = join_form.querySelector("input[name='u_tel']");
        const cname = join_form.querySelector("input[name='u_comp']");

        error_box_join.innerHTML = '';
        if (!id.value) {
            error_box_join.innerHTML = '아이디를 입력하세요';
            id.select();
            return false;
        } else {
            try {
                const res = await fetch(`${rootPath}/main/idcheck/${id.value}`);
                const json = await res.json().catch(null);
                if (json) {
                    error_box_join.innerHTML = '중복된 아이디입니다.';
                    id.select();
                    return false;
                }
            } catch (error) {
                console.log('아이디 사용 가능');
            }
        }
        if (!pw.value) {
            error_box_join.innerHTML = '비밀번호를 입력하세요';
            pw.select();
            return false;
        }
        if (!name.value) {
            error_box_join.innerHTML = '이름을 입력하세요';
            name.select();
            return false;
        }
        if (!tel.value) {
            error_box_join.innerHTML = '전화번호를 입력하세요';
            tel.select();
            return false;
        }
        if (!addr.value) {
            error_box_join.innerHTML = '주소를 입력하세요';
            addr.select();
            return false;
        }
        if (!cname.value) {
            error_box_join.innerHTML = '업체명을 입력하세요';
            cname.select();
            return false;
        } else {
            try {
                const res = await fetch(`${rootPath}/main/cnamecheck/${cname.value}`);
                const json = await res.json();
                // console.log(text);
                if (json) {
                    error_box_join.innerHTML = '중복된 업체명입니다. 다시 입력해주세요.';
                    cname.select();
                    return false;
                }
            } catch (error) {
                console.log('업체명 사용 가능');
            }
        }
        join_form.submit();
    });
});
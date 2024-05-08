document.addEventListener('DOMContentLoaded', async () => {
    const side_nav = document.querySelector('div.side');
    const login_form = document.querySelector('form.login');
    const join_form = document.querySelector('form.join');
    const join_btn = document.querySelector('button.join_btn');
    const login_btn = document.querySelector('button.login_btn');

    const error_box = document.querySelector('div.login.error');
    const error_box_join = document.querySelector('div.join.error');

    const cname = join_form.querySelector("input[name='u_comp']");
    const caddr = join_form.querySelector("input[name='c_addr']");
    const ctel = join_form.querySelector("input[name='c_tel']");
    const NAV = {
        home: { url: '/' },
        ticket: { url: '/ticket' },
        customer: { url: '/customer' },
        teacher: { url: '/teacher' },
        class: { url: '/class' },
        schedule: { url: '/schedule' },
        notice: { url: '/notice' },
        sales: { url: '/sales' },
    };

    side_nav?.addEventListener('click', (e) => {
        const target = e.target;
        if (target.tagName === 'LI') {
            const className = target.classList[0];
            const url = NAV[className].url;
            document.location.href = `${rootPath}${url}`;
        }
    });
    const path = document.location.pathname;

    const pathArr = path.split('/');

    pathArr[pathArr.length - 1 || pathArr.push('home')];

    const navs = Object.keys(NAV);
    navs.forEach((key) => {
        if (pathArr.join(' ').includes(key)) {
            document.querySelector(`div.side ul li.${key}`)?.classList.add('active');
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
            if (confirm('업체명을 비워두면 일반회원으로 가입됩니다. 그대로 진행할까요?')) {
                join_form.submit();
            } else {
                error_box_join.innerHTML = '업체명을 입력하세요';
                cname.select();
                return false;
            }
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
        alert('회원가입이 완료되었습니다.');
        join_form.submit();
    });

    cname.addEventListener('focus', () => {
        caddr.style.display = 'block';
        ctel.style.display = 'block';
    });
});

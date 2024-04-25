document.addEventListener('DOMContentLoaded', () => {
    const body = document.querySelector('tbody');

    const inputBox = document.querySelector('form.formBox');
    const us_id = inputBox.querySelector('input.us_uid');
    const us_uname = inputBox.querySelector('input.us_uname');
    const us_utel = inputBox.querySelector('input.us_utel');
    const us_cname = inputBox.querySelector('input.us_cname');
    const us_ccode = inputBox.querySelector('input.us_ccode');

    body.addEventListener('click', async (e) => {
        const target = e.target;
        if (target.tagName == 'TD') {
            const id = target.closest('TR').dataset.id;

            const res = await fetch(`${rootPath}/customer/get/${id}`);
            const json = await res.json();
            console.log(json);
        }
    });
});

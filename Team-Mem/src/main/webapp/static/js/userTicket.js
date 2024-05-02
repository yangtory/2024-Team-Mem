document.addEventListener('DOMContentLoaded', () => {
    const body = document.querySelector('tbody');

    body.addEventListener('click', (e) => {
        const target = e.target;
        if (target.tagName === 'TD') {
            const id = target.closest('TR').dataset.id;
            //   alert(seq);
            document.location.href = `${rootPath}/customer/tickdetail/${id}`;
        }
    });
});

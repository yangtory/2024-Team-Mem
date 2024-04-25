document.addEventListener('DOMContentLoaded', () => {
    const table = document.querySelector('table.ticket.list');

    table?.addEventListener('click', (e) => {
        const target = e.target;
        if (target.tagName === 'TD') {
            const seq = target.closest('TR').dataset.seq;
            // alert(seq);
            document.location.href = `${rootPath}/ticket/detail/${seq}`;
        }
    });
});

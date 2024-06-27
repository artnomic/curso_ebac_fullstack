$(document).ready(function () {
    $('form').on('submit', function (e) {
        e.preventDefault();

        const nomeNovaTarefa = $('#nova-tarefa').val();

        const novaTarefa = $('div .atividades');

        $(`
        <ul>
            <li>${nomeNovaTarefa}</li>
        </ul>
        `).appendTo(novaTarefa);
        $(novaTarefa).appendTo('</div>');
        $(novaTarefa).fadeIn(1000);

        $('#nova-tarefa').val('');
    })

    $('.atividades').on('click', 'ul li', function () {
        $(this).css('text-decoration', 'line-through');
    })
})
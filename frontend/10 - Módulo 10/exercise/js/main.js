$(document).ready(function () {
    $('#cpf').mask('000.000.000-00')
    $('#telefone').mask('(00) 00000-0000')
    $('#cep').mask('00000-000')

    $('form').validate({
        rules: {
            nome: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            telefone: {
                required: true
            },
            cpf: {
                required: true
            },
            rua: {
                required: true
            },
            numero: {
                required: true
            },
            complemento: {
                required: false
            },
            bairro: {
                required: true
            },
            cep: {
                required: true
            }
        },
        invalidHandler: function (e, validate) {
            let camposIncorretos = validate.numberOfInvalids();
            if (camposIncorretos) {
                alert(`Existem ${camposIncorretos} campos incorretos`)
            }
        }
    })

    $('.lista-veiculos button').click(function () {
        const destino = $('#contato');
        const nomeVeiculo = $(this).parent().find('h3').text();

        $('#veiculo-interesse').val(nomeVeiculo);

        $('html').animate({
            scrollTop: destino.offset().top
        }, 1000)
    })
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
$(document).ready(function () {
    $('#carrousel-imagens').slick({
        autoplay: true
    });

    $('.menu-hamburguer').click(function () {
        $('nav').slideToggle();
    })

    $('#telefone').mask('(00) 00000-0000')

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
            veiculoInteresse: {
                required: false
            },
            mensagem: {
                required: true
            }
        },
        messages: {
            nome: 'Por favor, insira o seu Nome',
            email: 'Por favor, insira o seu E-mail',
            telefone: 'Por favor, insira o seu Telefone'
        },
        invalidHandler: function(e, validate) {
            let camposIncorretos = validate.numberOfInvalids();
            if(camposIncorretos) {
                alert(`Existem ${camposIncorretos} campos incorretos`)
            }
        }
    })

    $('.lista-veiculos button').click(function(){
        const destino = $('#contato');
        const nomeVeiculo = $(this).parent().find('h3').text();

        $('#veiculo-interesse').val(nomeVeiculo);

        $('html').animate({
            scrollTop: destino.offset().top
        }, 1000)
    })
})
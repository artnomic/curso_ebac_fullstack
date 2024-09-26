$(document).ready(function () {
    $('#cep').mask('00000-000');

    $('#btn-buscar-cep').click(function () {
        const cep = $('#cep').val();
        const endpoint = `https://viacep.com.br/ws/${cep}/json/resultado`;
        const botao = $(this);

        $(botao).find('i').addClass('d-none');
        $(botao).find('span').removeClass('d-none');

        fetch(endpoint)
        .then(function (response) {
                console.log(response.json);
                return response.json();
            })
            .then(function (json) {
                const logradouro = json.logradouro;
                const bairro = json.bairro;
                const cidade = json.localidade;
                const estado = json.uf;

                const endereco = `${logradouro}, ${bairro} - ${cidade} - ${estado}`;
                $('#endereco').val(endereco);
            })
            .catch(function(erro) {
                alert("Ocorreu um erro ao buscar o CEP!");
            })
            .finally(function () {
                setTimeout(function () {
                    $(botao).find('i').removeClass('d-none');
                    $(botao).find('span').addClass('d-none');
                }, 500)
            })
    });

    $('#formulario-pedido').submit(function (event) {
        event.preventDefault();

        if($('#nome').val().length == 0) {   
            throw new Error('Preencha o nome!');
        }
    })
});
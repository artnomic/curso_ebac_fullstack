$(document).ready(function () {
    $('#btn-buscar-user').click(function () {
        const nome = $('#nome').val();
        const endpoint = `https://api.github.com/users/${nome}`;
        const botao = $(this);

        $(botao).find('i').addClass('d-none');
        $(botao).find('span').removeClass('d-none');

        fetch(endpoint)
            .then(function (response) {
                if (response.status !== 200) {
                    return Promise.reject('Erro: ' + response.status);
                }
                return response.json();
            })
            .then(function (json) {
                $('#avatar').attr('src', json.avatar_url);
                $('#profile-nome').text(json.name); 
                $('#username').text(json.login);
                $('#repositories').text(json.public_repos);
                $('#followers').text(json.followers);
                $('#following').text(json.following);
                $('#link').attr('href', json.html_url);
            })
            .catch(function (erro) {
                alert("Ocorreu um erro ao buscar o usuário: " + erro);
            })
            .finally(function () {
                setTimeout(function () {
                    $(botao).find('i').removeClass('d-none');
                    $(botao).find('span').addClass('d-none');
                    $('#link').removeClass('d-none');
                }, 500);
            });
    });
});

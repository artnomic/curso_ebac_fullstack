const form = document.getElementById('form-deposito');
const nomeBeneficiario = document.getElementById('nome-beneficiario');

function validaNome(nomeCompleto) {
    const nomeArray = nomeCompleto.split(' ');
    return nomeArray.length >= 2;
}

form.addEventListener('submit', function (e) {
    let formValido = false;
    e.preventDefault();
    

    const numeroContaBeneficiario = document.getElementById('numero-conta');
    const valorDeposito = document.getElementById('valor-deposito');
    const mensagemSucesso = `Montante de: R$ ${valorDeposito.value} depositado para o cliente ${nomeBeneficiario.value} - Conta: ${numeroContaBeneficiario.value}`
    
    formValido = validaNome(nomeBeneficiario.value)
    if (formValido) {
        const containerMensagemSucesso = document.querySelector('.success-message');
        containerMensagemSucesso.innerHTML = mensagemSucesso;
        containerMensagemSucesso.style.display = 'block';

        nomeBeneficiario.value = '';
        numeroContaBeneficiario.value = '';
        valorDeposito.value = '';

    } else {
        nomeBeneficiario.style.border = '1px solid red';
        document.querySelector('.error-message').style.display = 'block';
    }
})

nomeBeneficiario.addEventListener('keyup', function(e) {
    console.log(e.target.value);
    formValido = validaNome(e.target.value);

    if(!formValido) {
        nomeBeneficiario.classList.add('error');
        document.querySelector('.error-message').style.display = 'block';
    } else {
        nomeBeneficiario.classList.remove('error');
        document.querySelector('.error-message').style.display = 'none';
    }
});
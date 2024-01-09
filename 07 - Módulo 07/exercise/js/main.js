const form = document.getElementById('form-contadora');
const numberA = document.getElementById('numero-a');
const numberB = document.getElementById('numero-b');
const containerMensagemSucesso = document.querySelector('.success-message');

function validNumber(a, b) {
    
    return b > a;
}

form.addEventListener('submit', function (e) {
    let formValid = false;
    e.preventDefault();
    
    const mensagemSucesso = `Uhuul! O número B: ${numberB.value} é maior que o número A: ${numberA.value}`
    
    formValid = validNumber(numberA.value, numberB.value)

    if (formValid) {
        containerMensagemSucesso.innerHTML = mensagemSucesso;
        containerMensagemSucesso.style.display = 'block';

        numberA.value = '';
        numberB.value = '';
    } else {
        numberB.style.border = '1px solid red';
        document.querySelector('.error-message').style.display = 'block';
    }
})

numberB.addEventListener('change', function(e) {
    formValid = validNumber(numberA.value , numberB.value);

    if(!formValid) {
        numberB.classList.add('error');
        document.querySelector('.error-message').style.display = 'block';
    } else {
        numberB.classList.remove('error');
        document.querySelector('.error-message').style.display = 'none';
    }
});

numberA.addEventListener('change', function(e){
    containerMensagemSucesso.style.display = 'none';
})
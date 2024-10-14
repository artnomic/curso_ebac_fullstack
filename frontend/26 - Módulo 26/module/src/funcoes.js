"use strict";
function calcArea(base, altura) {
    return base * altura;
}
const calcArea2 = (base, altura) => base * altura;
function somar(...numeros) {
    console.log(numeros.reduce((acumulador, numeros) => acumulador + numeros, 0));
}
function teste() {
    if (10 > 5) {
        return "Dez maior que cinco";
    }
    else {
        return 10;
    }
}

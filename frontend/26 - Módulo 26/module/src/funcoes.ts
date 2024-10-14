function calcArea(base: number, altura: number): number {
    return base * altura;
}

const calcArea2 = (base: number, altura: number): number => base * altura;

function somar(...numeros: number[]): void {
    console.log(numeros.reduce((acumulador, numeros) => acumulador + numeros, 0)); 
}

function teste(): string | number {
    if(10>5) {
        return "Dez maior que cinco";
    } else {
        return 10;
    }
}
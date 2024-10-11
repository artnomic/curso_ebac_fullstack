function somar() {
  let soma = 0;
  for (let i = 0; i < arguments.length; i++) {
    soma += arguments[i];
  }
  return soma;
}

//rest
function somarComRest(...numeros) {
    const soma = numeros.reduce((total, numeroAtual) => {
        total += numeroAtual;
        return total;
    }, 0)
    return soma;
}

console.log(somarComRest(1, 2, 3, 4, 5));


//spread 
const numeros = [1, 2, 3, 4, 5];
console.log(...numeros);

const timesDeFutebolDeSp = ['Corinthians', 'Palmeiras', 'São Paulo', 'Santos', 'Bragantino'];
const timesDeFutebolDoRio = ['Flamengo', 'Fluminense', 'Botafogo', 'Vasco'];

// const timesDeFutebol = timesDeFutebolDeSp.concat(timesDeFutebolDoRio);
const timesDeFutebol = [...timesDeFutebolDeSp, ...timesDeFutebolDoRio];

console.log(timesDeFutebol)

const carroDaJulia = {
    modelo: 'gol',
    marca: 'vw',
    motor: 1.6
}

const carroDaAna = {
    ...carroDaJulia,
    motor: 1.8
}

//desestruturação
// const motorDoCarroDaAna = carrpDaAna.motor;
const {motor: motorDoCarroDaAna } = carroDaAna;
const {motor: motorDoCarroDaJulia} = carroDaJulia;

const [item1, item2, item3, ...outrosItens] = timesDeFutebol;
console.log(outrosItens)
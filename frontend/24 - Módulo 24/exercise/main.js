function Animal(tipo, alimentacao, acao) {
    this.tipo = tipo;
    this.alimentacao = alimentacao;
    this.acao = acao;
    this.realizaAcao = function() {
        return `O ${this.tipo} está ${this.acao}.`;
    };
}

function Gato(porte, cor, idade, apelido) {
    this.porte = porte;
    this.cor = cor;
    this.idade = idade;
    this.apelido = apelido;

    Animal.call(this, "Gato", "Ração", "mia");
}

function Leao(tamanho, genero, idade, domesticado) {
    this.tamanho = tamanho;
    this.genero = genero;
    this.idade = idade;
    this.domesticado = domesticado;

    Animal.call(this, "Leao", "Carne", "Ruge");
}

const fifi = new Gato("Pequeno", "Branco", 3, "Fifi");
const leao = new Leao("1.5", "Masculino", 2, false);
const catarina = new Gato("Pequeno", "Frajola", 3, "Catarina");

console.log(fifi, leao, catarina);
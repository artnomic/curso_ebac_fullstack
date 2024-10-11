// function Pokemon (nome, tipo) {
//     this.nome = nome;
//     this.tipo = tipo;
// }

// const pikachu = new Pokemon("Pikachu", "electric");

class Pokemon {
    constructor(nome, tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    atacar(nomeDoAtacante) {
        console.log(`${this.nome} ataca ${nomeDoAtacante}`);
    }
}

class Pikachu extends Pokemon {
    #hp = 100;

    constructor() {
        super('Pikachu', 'electric');
    }

    atacar() {
        console.log(`${this.nome} ataca com o Choque do Trovão`);
    }
    
    atacado() {
        this.#hp -= 10;
    }


    getHp() {
        console.log(this.#hp);
    }
}

const pikachu = new Pikachu();
pikachu.atacar("Golpe máximo");

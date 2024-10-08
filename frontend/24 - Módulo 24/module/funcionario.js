function Pessoa(nome) {
    this.nome = nome;
    this.dizOi = function () {
        console.log(this.nome + " diz oi!");
    }
}

function Funcionario(nome, cargo, salario) {
    this.cargo = cargo;
    this.salario = salario;

    this.dizCargo = function () {
        console.log(this.cargo);
    }

    Pessoa.call(this, nome);
}

const funcionario1 = new Funcionario("Arthur", "Programador", 1000);
console.log(funcionario1);
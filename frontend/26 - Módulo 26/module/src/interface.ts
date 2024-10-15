class Conta {
  numeroConta: number;
  saldo: number = 0;

  constructor(numeroConta: number) {
    this.numeroConta = numeroConta;
  }
}

class ContaSalario extends Conta {
    depositar(valor: number) {
        this.saldo += valor;
    }
}

interface ITransacional {
    transferir: (valor:number, destinatario: Conta) => boolean;
    taxaTransferencia: number;
}

class ContaCorrente extends Conta implements ITransacional {
    transferir(valor: number, destinatario: Conta){
        destinatario.saldo += valor;
        return true;
    };
    taxaTransferencia: number = 0;
}
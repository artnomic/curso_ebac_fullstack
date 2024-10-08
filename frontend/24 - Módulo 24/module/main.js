function Carro(modelo, fabricante, anoModelo, anoFabricacao) { 
    this.modelo = modelo;
    this.fabricante = fabricante;
    this.anoModelo = anoModelo;
    this.anoFabricacao = anoFabricacao;
}

const creta = new Carro("Creta", "Hyundai", "2025", "2024");
const hb20 = new Carro("HB20", "Hyundai", "2025", "2024");

console.log(`Tenho a venda um: ${creta.modelo}. Mas caso queira mais informações sobre o outro: \n ${hb20.Carro}`); 

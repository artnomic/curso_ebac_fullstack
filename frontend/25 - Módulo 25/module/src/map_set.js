let meuMap = new Map();
meuMap.set("nome", "art");
meuMap.set("stack", "html, css, js, java"); 

console.log(meuMap);

const nome = meuMap.get("nome");
console.log(nome);

console.log(meuMap.size);
console.log(meuMap.has("sobrenome"));
// meuMap.clear();

for (let chave of meuMap.keys()) {
    console.log(chave);
}

for (let valor of meuMap.values()) {
    console.log(valor);
}

for (let [chave, valor] of meuMap.entries()) {
    console.log(`${chave}: ${valor}`);
}


//sets
const cpfs = new Set();
cpfs.add("123456789");
cpfs.add("987654321");
cpfs.add("123456789");
cpfs.add("987654321");
cpfs.add("111111111");

console.log(cpfs);

const numeros = [1, 2, 3, 4, 5];
const numeros2 = [1, 2, 3, 4, 5];

numeros.forEach(function (numero) {
    console.log(numero);
});

const array = [1, 2, 3, 4, 5, 5, 6, 7, 7,9, 10];

//Metodo EBAC
const arrayComSet = new Set([...array]);
console.log(arrayComSet);
const arraySemDuplicados = [...arrayComSet];
console.log(arraySemDuplicados);

//Metodo que Pensei
const arraySemDuplicados2 = [...new Set([...array])];
console.log(arraySemDuplicados2)

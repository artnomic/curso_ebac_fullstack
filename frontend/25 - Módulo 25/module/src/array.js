const redesSociais = [
  "Facebook",
  "Twitter",
  "Instagram",
  "Youtube",
  "Linkedin",
];

for (let i = 0; i < redesSociais.length; i++) {
  console.log(`Tenho perfil na rede social: ${redesSociais[i]}`);
}

redesSociais.forEach(function (redesSociais, indice) {
  console.log(`#${indice + 1} Tenho perfil na rede social: ${redesSociais}`);
});

const alunos = ["Arthur", "Maria", "Pedro", "João", "Ana"];

const alunos2 = alunos.map(function (itemAtaul) {
  return {
    nome: itemAtaul,
    curso: "Sistemas de Informação",
  };
});
console.log(alunos2);

const numeros = [1, 2, 3, 4, 5];
const dobros = numeros.map(function (numero) {
  return numero * 2;
});

console.log(dobros);

const paula = alunos2.find(function (numero) {
  return numero.nome === "Paula";
});

console.log(paula);

const indicePaula = alunos2.findIndex(function (item) {
  return item.nome === "Paula";
});

console.log(indicePaula);

const every = alunos2.every(function (item) {
  return item.curso === "Sistemas de Informação";
});

console.log(every);

const some = alunos2.some(function (item) {
  return item.curso === "Sistemas de Informação";
});

console.log(some);

const nomeFilter = alunos2.filter(function (item) {
  return item.nome === "Arthur";
});
console.log(nomeFilter);

const nums = [10, 20, 30];
const soma = nums.reduce(function (total, itemAtual) {
  total += itemAtual;
  return total;
}, 0); 
console.log(soma);
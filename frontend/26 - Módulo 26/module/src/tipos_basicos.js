"use strict";
let estaChovendo = false;
estaChovendo = true;
//o tipo number não diferencia inteiros e decimais
let idade = 23;
let altura = 1.60;
const nacionalidade = "Brasileira";
const colegas = ["Arthur", "Maria", "Pedro", "João", "Ana", "Paula", "Marcos", "Pedro", "Miguel"];
const tecnologias = ["Javascript", "Typescript", "React", "Node", "Angular", "Vue", "PHP", "C#", "C++"];
//Array apenas de Leitura:
const notas = [10, 9, 8, 7, 6, 5, 4, 3, 2];
//Array de Tupla (com diversos tipos)
const lista = ["Arthur", 23, "Brasileira", true];
//Forma de união de tipos
const idadeDaAna = 25;
//O Any não é recomendado, pois pode ser usado para qualquer coisa e foge da proposta do Typescript.
let dadosDaApi;
dadosDaApi = 10;
dadosDaApi = true;
dadosDaApi = [1, 2, 3];
dadosDaApi = { nome: "Arthur", idade: 23, nacionalidade: "Brasileira", estudando: true };
//Tipagem implícita
let idadeImplicita = 25;
// idadeImplicita = "Arthur";

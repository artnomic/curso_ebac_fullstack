let estaChovendo: boolean = false;
estaChovendo = true;

//o tipo number não diferencia inteiros e decimais
let idade: number = 23;
let altura: number = 1.60;

const nacionalidade: string = "Brasileira";

const colegas:string[] = ["Arthur", "Maria", "Pedro", "João", "Ana", "Paula", "Marcos", "Pedro", "Miguel"];
const tecnologias: Array<string> = ["Javascript", "Typescript", "React", "Node", "Angular", "Vue", "PHP", "C#", "C++"];

//Array apenas de Leitura:
const notas: ReadonlyArray<number> = [10, 9, 8, 7, 6, 5, 4, 3, 2];

//Array de Tupla (com diversos tipos)
const lista: [nome: string, idade: number, nacionalidade: string, estudando: boolean] = ["Arthur", 23, "Brasileira", true];

//Forma de união de tipos
const idadeDaAna: number | string = 25;


//O Any não é recomendado, pois pode ser usado para qualquer coisa e foge da proposta do Typescript.
let dadosDaApi: any;
dadosDaApi = 10;
dadosDaApi = true;
dadosDaApi = [1,2,3]
dadosDaApi = {nome: "Arthur", idade: 23, nacionalidade: "Brasileira", estudando: true};
"use strict";
const alunos = [
    {
        nome: "Arthur",
        cursos: ["C#", "Javascript", "Typescript"],
        idade: 23,
    },
    {
        nome: "Maria",
        cursos: ["Javascript", "Typescript", "React"],
        idade: 25,
    },
];
alunos.push({
    nome: "Pedro",
    cursos: ["Arquitetura"],
    idade: 15,
});
const novoAluno = {
    nome: "João",
    idade: 25,
};
function exibeAlunos(aluno) {
    console.log(aluno.nome);
}

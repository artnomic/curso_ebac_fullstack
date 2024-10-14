type aluno = {
    nome: string,
    cursos?: string[],
    idade: number
}

const alunos: aluno[] = [
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
})

const novoAluno: aluno = {
    nome: "João",
    idade: 25,
}

function exibeAlunos(aluno: aluno) {
    console.log(aluno.nome);
}
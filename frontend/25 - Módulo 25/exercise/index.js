const alunos = [{notas: 10, nome: "Arthur"}, {notas: 9, nome: "Maria"}, {notas: 8, nome: "Pedro"}, {notas: 7, nome: "João"}, {notas: 6, nome: "Ana"}, {notas: 5, nome: "Paula"}, {notas: 4, nome: "Marcos"}, {notas: 3, nome: "Pedro"}, {notas: 2, nome: "Miguel"}];

// function aprovados(alunos) {
//     const aprovados = alunos.filter(function (aluno) {
//         return aluno.notas >= 6;
//       });
//     return aprovados;
// }

// const aprovados = alunos => alunos.filter(function (aluno) {
//     return aluno.notas >= 6;
// })

const aprovados = alunos => alunos.filter(aluno => aluno.notas >= 6);


console.log(aprovados(alunos));
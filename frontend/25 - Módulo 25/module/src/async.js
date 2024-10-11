function funcMuitoPesada() {
  let execucoes = 0;
  for (let i = 0; i < 1000000000; i++) {
    execucoes++;
  }
  return execucoes;
}

const funcMuitoPesadaPromise = new Promise((resolve, reject) => {
  try {
    let execucoes = 0;
    for (let i = 0; i < 1000000000; i++) {
      execucoes++;
    }
    resolve(execucoes);
  } catch (erro) {
    reject(erro);
  }
});

console.log("inicio");
funcMuitoPesada();
funcMuitoPesadaPromise
  .then(function (resultado) {
    console.log(resultado);
  })
  .catch(function (erro) {
    console.log(erro);
  });

console.log("fim");

async function execucaoPrincipal() {
  console.log("inicio");
  funcMuitoPesada();
  
  await funcMuitoPesadaPromise
    .then(function (resultado) {
      console.log(resultado);
    })
    .catch(function (erro) {
      console.log(erro);
    });

  console.log("fim");
}

execucaoPrincipal();
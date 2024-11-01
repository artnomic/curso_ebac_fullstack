function App() {

  const pessoa = {
    nome: "Rodrigo"
  }

  let estaDeDia = false;

  return (
    <>
      <h1>Olá {pessoa.nome}</h1>
      <h2>Informação</h2>
      {estaDeDia ? 'Bom dia!': 'Boa tarde!'}
    </>
  );
}

export default App

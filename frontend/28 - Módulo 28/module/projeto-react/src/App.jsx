import { useState } from 'react';

import Perfil from './components/Perfil';
import Formulario from './components/Formulario';
import ReposList from './components/ReposList';

function App() {
  const [formularioEstaVisivel, setFormularioEstaVisivel] = useState(true);

  return (
    <>
      <Perfil nome="Arthur" endereco="https://github.com/artnomic.png" />
      <ReposList/>
      
      {/* {formularioEstaVisivel && <Formulario />}
      <button onClick={() => setFormularioEstaVisivel(!formularioEstaVisivel)}> Toggle Form</button> */}
    </>
  );
}

export default App

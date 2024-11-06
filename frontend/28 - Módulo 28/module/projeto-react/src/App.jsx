import { useState } from 'react';

import Perfil from './components/Perfil';
import ReposList from './components/ReposList';

function App() {
  const [nomeDeUsuario, setnomeDeUsuario] = useState('');

  return (
    <>
      <div className='container'>
        <input className='container input' type="text" placeholder='Informe o nome de usuário do GitHub' onBlur={e => setnomeDeUsuario(e.target.value)} />
      </div>
      {nomeDeUsuario.length >= 4 && (
        <>
          <Perfil nomeDeUsuario={nomeDeUsuario} />
          <ReposList nomeDeUsuario={nomeDeUsuario} />
        </>
      )}
    </>
  );
}

export default App

import './perfil.css';

const Perfil = () => {
    const usuario = {
        nome: 'Arthur Berson',
        avatar: 'https://github.com/artnomic.png',
    }

    return (
        <div>
            <img className='perfil-avatar' src={usuario.avatar} alt="Avatar" />
            <h3 className='perfil-titulo'>{usuario.nome}</h3>
        </div>
    );
};

export default Perfil;
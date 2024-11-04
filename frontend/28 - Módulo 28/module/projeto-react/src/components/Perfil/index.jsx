import './perfil.css';

// eslint-disable-next-line react/prop-types
const Perfil = ({ nome, endereco }) => {
    return (
        <div>
            <img className='perfil-avatar' src={endereco} alt="Avatar" />
            <h3 className='perfil-titulo'>{nome}</h3>
        </div>
    );
};

export default Perfil;
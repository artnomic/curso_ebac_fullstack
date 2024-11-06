import styles from './Perfil.module.css';

// eslint-disable-next-line react/prop-types
const Perfil = ({ nomeDeUsuario }) => {
    return (
        <header className={styles.header}>
            <img className={styles.avatar} src={`https://github.com/${nomeDeUsuario}.png`} alt="Avatar" />
            <h1 className={styles.name}>{nomeDeUsuario}</h1>
        </header>
    );
};

export default Perfil;
/* eslint-disable react/prop-types */
import { useEffect, useState } from "react";
import styles from './ReposList.module.css';

const ReposList = ({ nomeDeUsuario }) => {
    const [repos, setRepos] = useState([]);
    const [estaCarregando, setEstaCarregando] = useState(true);
    const [deuErro, setDeuErro] = useState(false);

    useEffect(() => {
        setEstaCarregando(true);
        fetch(`https://api.github.com/users/${nomeDeUsuario}/repos`)
            .then(res => {
                if (!res.ok) {
                    throw new Error("Usuário não encontrado!")
                }
                return res.json();
            })
            .then(resJson => {
                setTimeout(() => {
                    setEstaCarregando(false);
                    setDeuErro(false)
                    setRepos(Array.isArray(resJson) ? resJson : []);
                }, 1000);
            })
            .catch(e => {
                setEstaCarregando(false);
                setDeuErro(true);
                setRepos([]);
                console.error("Erro ao buscar repositórios:", e);
            });
    }, [nomeDeUsuario]);

    return (
        <div className="container">
            {estaCarregando ? (
                <div className={styles.infos}>
                    <span className={styles.loading}>Carregando...</span>
                </div>
            ) : (
                deuErro ? (
                    <div className={styles.infos}>
                        <span className={styles.loading}>Desculpe, esse usuário &quot;{nomeDeUsuario}&quot; não existe! Tente novamente!</span>
                    </div>
                ) : (
                    <ul className={styles.list}>
                        {repos.map(({ id, name, language, html_url }) => (
                            <li key={id} className={styles.listItem}>
                                <div className={styles.itemName}>
                                    <b>Nome: </b>
                                    {name}
                                </div>
                                <div className={styles.itemLanguage}>
                                    <b>Linguagem: </b>
                                    {language}
                                </div>
                                <a
                                    className={styles.itemLink}
                                    href={html_url}
                                    target="_blank"
                                    rel="noopener noreferrer"
                                >
                                    <b>Visitar no GitHub</b>
                                </a>
                            </li>
                        ))}
                    </ul>
                )
            )}
        </div>
    );
};

export default ReposList;

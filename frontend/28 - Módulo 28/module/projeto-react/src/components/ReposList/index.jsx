/* eslint-disable react/prop-types */
import { useEffect, useState } from "react";

import styles from './ReposList.module.css';

const ReposList = ({ nomeDeUsuario }) => {
    const [repos, setRepos] = useState([]);
    const [estaCarregando, setestaCarregando] = useState([true]);

    useEffect(() => {
        setestaCarregando(true);
        fetch(`https://api.github.com/users/${nomeDeUsuario}/repos`)
            .then(res => res.json())
            .then(resJson => {
                setTimeout(() => {
                    setestaCarregando(false);
                    setRepos(resJson);
                }, 1000);
            })
    }, [nomeDeUsuario]);

    return (
        <div className="container">
            {estaCarregando ? (
                <span className={styles.loading}>Carregando...</span>
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
                            <a className={styles.itemLink} href={html_url} target="_blank">
                                <b>Visitar no GitHub</b>
                            </a>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default ReposList;
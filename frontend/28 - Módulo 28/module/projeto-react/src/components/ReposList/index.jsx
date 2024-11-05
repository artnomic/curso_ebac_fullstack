import { useEffect, useState } from "react";

const ReposList = () => {
    const [repos, setRepos] = useState([]);

    useEffect(() => {
        fetch('https://api.github.com/users/artnomic/repos')
            .then(res => res.json())
            .then(resJson => {
                console.log(resJson);
                setRepos(resJson);
            })
    }, []);

    return (
        <ul>
            {repos.map(({id, name, language, html_url}) => (
                <li key={id}>
                    <b>Nome: </b>{name} <br />
                    <b>Linguagem: </b>{language} <br />
                    <a href={html_url} target="_blank"><b>Visitar no GitHub</b></a> <br /><br />
                </li>
            ))}
        </ul>
    );
};

export default ReposList;
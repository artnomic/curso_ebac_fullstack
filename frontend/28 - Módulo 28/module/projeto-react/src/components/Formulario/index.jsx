/* eslint-disable react/jsx-key */
import { useEffect, useState } from "react";

const Formulario = () => {
    const [materiaA, setMateriaA] = useState(0);
    const [materiaB, setMateriaB] = useState(0);
    const [materiaC, setMateriaC] = useState(0);
    const [nome, setNome] = useState('Aluno');

    useEffect(() => {
        console.log("O nome é:", nome);
    }, [nome])

    useEffect(() => {
        console.log("O componente iniciou");

        return () => {
            console.log("O componente foi removido");
        }
    }, [])

    const alteraNome = e => {
        setNome(e.target.value);
    }

    const renderizaResultado = () => {
        const media = (materiaA + materiaB + materiaC) / 3;
        
        if (media >= 7) {
            return (
                <p>Você, {nome}, foi aprovado por conta da média: {media}</p>
            )
        } else {
            return (
                <p>Você, {nome}, não foi aprovado por conta da média: {media}</p>
            )
        }


    }

    return (
        <form>
            {[1, 2, 3, 4, 5].map(item => (
                <li key={item}>{item}</li>
            ))}

            <input type="text" placeholder="Informe o seu Nome!" onChange={alteraNome}/>
            <input type="number" placeholder="Nota matéria A" onChange={e => setMateriaA(parseInt(e.target.value))} /> 
            <input type="number" placeholder="Nota matéria B" onChange={e => setMateriaB(parseInt(e.target.value))} />
            <input type="number" placeholder="Nota matéria C" onChange={e => setMateriaC(parseInt(e.target.value))} />
            {renderizaResultado()}
        </form>
    );
};

export default Formulario;
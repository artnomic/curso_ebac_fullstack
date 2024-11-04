import { useState } from "react";

const Formulario = () => {
    let [materiaA, setMateriaA] = useState(0);
    let [materiaB, setMateriaB] = useState(0);
    let [materiaC, setMateriaC] = useState(0);
    let [nome, setNome] = useState('Aluno');

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
            <input type="text" placeholder="Informe o seu Nome!" onChange={alteraNome}/>
            <input type="number" placeholder="Nota matéria A" onChange={e => setMateriaA(parseInt(e.target.value))} /> 
            <input type="number" placeholder="Nota matéria B" onChange={e => setMateriaB(parseInt(e.target.value))} />
            <input type="number" placeholder="Nota matéria C" onChange={e => setMateriaC(parseInt(e.target.value))} />
            {renderizaResultado()}
        </form>
    );
};

export default Formulario;
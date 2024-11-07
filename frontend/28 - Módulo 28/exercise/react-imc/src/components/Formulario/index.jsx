import { useEffect, useState } from 'react';
import styles from './Formulario.module.css';

const Formulario = () => {
    const [pesoUser, setPesoUser] = useState(0.0);
    const [alturaUser, setAlturaUser] = useState(0.0);
    const [imc, setImc] = useState(0.0);

    const getIMCClassification = () => {
        if (imc < 18.5) return 'Abaixo do Peso';
        if (imc >= 18.5 && imc < 25) return 'Peso Normal';
        if (imc >= 25 && imc < 30) return 'Sobrepeso';
        if (imc >= 30 && imc < 35) return 'Obesidade Grau I';
        if (imc >= 35 && imc < 40) return 'Obesidade Grau II';
        return 'Obesidade Grau III';
    };

    useEffect(() => {
        if (alturaUser > 0) setImc((pesoUser) / (alturaUser * alturaUser));
    }, [pesoUser, alturaUser]);

    const classification = getIMCClassification();

    return (
        <div className='container'>
            <div className={styles.formsContainer}>
                <input
                    className={styles.formsElement}
                    type="number"
                    step="0.01"
                    placeholder='Informe o seu Peso'
                    onChange={e => setPesoUser(parseFloat(e.target.value))}
                />
                <input
                    className={styles.formsElement}
                    type="number"
                    step="0.01"
                    placeholder='Informe a sua Altura'
                    onChange={e => setAlturaUser(parseFloat(e.target.value))}
                />
            </div>
            <div className={styles.returnElement}>
                <p>Seu IMC é: <b>{imc.toFixed(2)}</b></p>
            </div>
            <div className={styles.tableContainer}>
                <h3>Classificação do IMC</h3>
                <table className={styles.table}>
                    <thead>
                        <tr>
                            <th>Classificação</th>
                            <th>IMC (kg/m²)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr className={classification === 'Abaixo do Peso' ? styles.highlight : ''}>
                            <td>Abaixo do Peso</td>
                            <td>Menor que 18,5</td>
                        </tr>
                        <tr className={classification === 'Peso Normal' ? styles.highlight : ''}>
                            <td>Peso Normal</td>
                            <td>18,5 - 24,9</td>
                        </tr>
                        <tr className={classification === 'Sobrepeso' ? styles.highlight : ''}>
                            <td>Sobrepeso</td>
                            <td>25,0 - 29,9</td>
                        </tr>
                        <tr className={classification === 'Obesidade Grau I' ? styles.highlight : ''}>
                            <td>Obesidade Grau I</td>
                            <td>30,0 - 34,9</td>
                        </tr>
                        <tr className={classification === 'Obesidade Grau II' ? styles.highlight : ''}>
                            <td>Obesidade Grau II</td>
                            <td>35,0 - 39,9</td>
                        </tr>
                        <tr className={classification === 'Obesidade Grau III' ? styles.highlight : ''}>
                            <td>Obesidade Grau III</td>
                            <td>Maior ou igual a 40,0</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default Formulario;

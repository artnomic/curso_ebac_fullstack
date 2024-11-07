import styles from './IMC.module.css';
import images from '../../images/art.jpeg';

const IMC = () => {
    return (
        <div className="container">
            <div className={styles.infoContainer}>
                <div className={styles.textContainer}>
                    <div className={styles.infoContent}>
                        <h2>Importância do IMC</h2>
                        <p>
                            O Índice de Massa Corporal (IMC) é uma medida importante para avaliar se uma pessoa está em um peso adequado para sua altura.
                            Ele é amplamente utilizado por profissionais de saúde para identificar rapidamente se alguém está abaixo do peso, com peso saudável,
                            sobrepeso ou obesidade. Isso ajuda a orientar sobre riscos associados a doenças como diabetes, hipertensão e problemas cardiovasculares.
                            Embora o IMC não leve em consideração a composição corporal (como massa muscular e gordura), ele é uma ferramenta prática para o
                            monitoramento de peso.
                        </p>
                    </div>
                    <div className={styles.infoContent}>
                        <h3>Como calcular o IMC:</h3>
                        <p>
                            Para calcular o IMC, usa-se a fórmula:
                        </p>
                        <pre>
                            IMC = peso (kg) / altura (m)²
                        </pre>
                    </div>
                </div>
                <div className={styles.imgContainer}>
                    <img className={styles.imgModel} src={images} alt="" />
                    <p>Arthur Berson</p>
                </div>
            </div>
        </div>
    );
};

export default IMC;
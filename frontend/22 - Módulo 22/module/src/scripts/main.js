const dataDoEvento = new Date("Dec 12, 2024 19:00:00");
const timeStampdoEvento = dataDoEvento.getTime();

const contaAsHoras = setInterval(function() {
    const dataAtual = new Date();
    const timeStampAtual = dataAtual.getTime();

    const distanciaAteOEvento = timeStampdoEvento - timeStampAtual;

    const diasEmMs = 1000 * 60 * 60 * 24;
    const horaEmMs = 1000 * 60 * 60;
    const minutoEmMs = 1000 * 60;

    const diasAteOEvento = Math.floor(distanciaAteOEvento/diasEmMs);
    const horasAteOEvento = Math.floor((distanciaAteOEvento % diasEmMs) / horaEmMs);
    const minutosAteOEvento = Math.floor((distanciaAteOEvento % horaEmMs) / minutoEmMs); 
    const segundosAteOEvento = Math.floor((distanciaAteOEvento % minutoEmMs)/1000);

    document.getElementById('contador').innerHTML = `${diasAteOEvento} dias, ${horasAteOEvento} horas, ${minutosAteOEvento} minutos e ${segundosAteOEvento} segundos`;

    if(distanciaAteOEvento < 0) {
        clearInterval(contaAsHoras);
        document.getElementById('contador').innerHTML = 'O evento já acabou!';
    }
}, 1000);
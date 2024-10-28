<script setup>
import { reactive } from 'vue';
import Header from './components/Header.vue';
import Forms from './components/Forms.vue';
import Calculator from './components/Calculator.vue';


const getSum = (a, b) => Number(a) + Number(b);
const getSub = (a, b) => a - b;
const getMul = (a, b) => a * b;
const getDiv = (a, b) => a / b;

const estado = reactive({
    operacao: 'soma',
    valueA: 0,
    valueB: 0,
    totalValue: 0,
});

const getValueA = () => {
    return estado.valueA;
};

const getValueB = () => {
    return estado.valueB;
};

const getSelect = () => {
    const { operacao } = estado;

    switch (operacao) {
        case 'subtração':
            return 'Subtração';
        case 'multiplicação':
            return 'Multiplicação';
        case 'divisão':
            return 'Divisão';
        default:
            return 'Soma';
    }
};

const getOperacao = () => {
    const { operacao } = estado;

    switch (operacao) {
        case 'subtração':
            return getSub(estado.valueA, estado.valueB);
        case 'multiplicação':
            return getMul(estado.valueA, estado.valueB);
        case 'divisão':
            return getDiv(estado.valueA, estado.valueB);
        default:
            return getSum(estado.valueA, estado.valueB);
    }
}

</script>

<template>
    <div class="container ">
        <Header 
        :getSelect="getSelect()" 
        :valueA="getValueA()"
        :valueB="getValueB()" />

        <Forms 
        :getSelect="evento => estado.operacao = evento.target.value" 
        :editValueA="evento => estado.valueA = evento.target.value" 
        :editValueB="evento => estado.valueB = evento.target.value" 
        :valueA="getValueA()"
        :valueB="getValueB()" 
        />

        <Calculator :totalValue="getOperacao()"/>

    </div>
</template>

<style scoped></style>

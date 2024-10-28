<script setup>
const props = defineProps(['getSelect', 'valueA', 'valueB']);
</script>

<template>
    <header class="p-5 mb-4 bg-light rounded-3 text-center">
        <h1>Calculadora do Art</h1>
        <div class="bg-light rounded-3 p-5 text-center">
            <p>Você está atualmente usando a calculadora de "{{ props.getSelect }}" para realizar suas operações.</p>
            <p>O Primeiro valor é o valor que você digitou na primeira coluna: {{ props.valueA }}</p>
            <p>O Segundo valor é o valor que você digitou na segunda coluna: {{ props.valueB }}</p>
        </div>
    </header>
</template>
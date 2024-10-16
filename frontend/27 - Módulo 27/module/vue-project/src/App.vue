<script setup>

const nome = "Arthur";
const meuObj = {
  nome: "Arthur",
  sobrenome: "Berson",
  idade: 23,
  filmeFavorito: "Creed"
}

const nomeCompleto = `${nome} ${meuObj.sobrenome}`;

function dizOi(nome) {
  return `Oi, ${nome}!`;
}

const depay = "https://soucg.com.br/wp-content/uploads/2024/10/Memphis-Depay-pode-deixar-o-Corinthians-apos-crise-com-patrocinadora-768x576.jpg"
const garro = "https://stcotvfoco.com.br/2024/10/rodrigo-garro.jpg"

</script>

<template>
  <h1>Olá {{nomeCompleto}}</h1>
  <img v-bind:src="depay" alt="Memphis Depay">
  <img :src="garro" alt="Rodrigo Garro">
</template>

<style scoped>

</style>

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

const gostaDoMemphisDepay = false;
const gostaDoGarro = false;

</script>

<template>
  <h1>Olá {{nomeCompleto}}</h1>
  <img v-if="gostaDoMemphisDepay" v-bind:src="depay" alt="Memphis Depay">
  <img v-else-if="gostaDoGarro" v-bind:src="garro" alt="Rodrigo Garro">
  <h2 v-else>Não curte nenhum jogador do Corinthians.</h2>

  <p>Oi, {{nomeCompleto}}!</p>
  <p>{{nome}} tem {{meuObj.idade}} anos.</p>
  <p>O filme favorito é {{meuObj.filmeFavorito}}.</p>
  <p>{{dizOi(nome)}}</p>
</template>



<style scoped>
img {
  max-width: 200px;
}
</style>

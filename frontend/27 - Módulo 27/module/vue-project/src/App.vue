<script setup>
import { reactive } from "vue";

const nome = "Arthur";
const meuObj = {
  nome: "Arthur",
  sobrenome: "Berson",
  idade: 23,
  filmeFavorito: "Creed",
};

const nomeCompleto = `${nome} ${meuObj.sobrenome}`;

function dizOi(nome) {
  return `Oi, ${nome}!`;
}

const depay =
  "https://soucg.com.br/wp-content/uploads/2024/10/Memphis-Depay-pode-deixar-o-Corinthians-apos-crise-com-patrocinadora-768x576.jpg";
const garro = "https://stcotvfoco.com.br/2024/10/rodrigo-garro.jpg";

const gostaDoMemphisDepay = false;
const gostaDoGarro = false;

// let contador = 0;
const estado = reactive({
  contador: 0,
  email: ' ',
});

function incrementa() {
  estado.contador++;
}

function decrementa() {
  estado.contador--;
}

function alteraEmail(evento) {
  estado.email = evento.target.value;
}

</script>

<template>
  <h1>Olá {{ nomeCompleto }}</h1>
  <img v-if="gostaDoMemphisDepay" v-bind:src="depay" alt="Memphis Depay" />
  <img v-else-if="gostaDoGarro" v-bind:src="garro" alt="Rodrigo Garro" />
  <h2 v-else>Não curte nenhum jogador do Corinthians.</h2>

  <br />
  <hr />

  <p>Oi, {{ nomeCompleto }}!</p>
  <p>{{ nome }} tem {{ meuObj.idade }} anos.</p>
  <p>O filme favorito é {{ meuObj.filmeFavorito }}.</p>
  <p>{{ dizOi(nome) }}</p>

  <br />
  <hr />

  {{ estado.contador }}

  <button type="button" @click="incrementa()">+</button>
  <button type="button" @click="decrementa()">-</button>

  <br />
  <hr />

  {{ estado.email }}
  <!-- <input type="email" @keyup="evento => estado.email = evento.target.value" /> -->
  <input type="email" @keyup="alteraEmail" />
</template>

<style scoped>
img {
  max-width: 200px;
}
</style>

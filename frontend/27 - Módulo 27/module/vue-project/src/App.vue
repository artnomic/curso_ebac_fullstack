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
  saldo: 5000,
  transferindo: 0,
  nomes: ['Arthur', 'Giovanna', 'Rodrigo', 'Maria'],
  nomeAInserir: '',
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

function mostraSaldoFuturo() {
  const {saldo, transferindo} = estado
  return saldo - transferindo;
}

function validaValorTransferencia() {
  const {saldo, transferindo} = estado
  return saldo >= transferindo;
}

function cadastraNome() {
  if(estado.nomeAInserir.length <= 2) return;
  if(estado.nomes.includes(estado.nomeAInserir)) return;

  return estado.nomes.push(estado.nomeAInserir);
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

  <br />
  <hr />

  Saldo: {{ estado.saldo }}
  <br />
  Transferindo: {{ estado.transferindo }}
  <br />
  Saldo futuro: {{ mostraSaldoFuturo() }}
  <br />
  <input :class= "{ invalido: !validaValorTransferencia() }" type="number" @keyup="evento => estado.transferindo = evento.target.value" />
  <br />
  <button v-if="validaValorTransferencia()" type="button">Transferir</button>
  <span v-else>Valor insuficiente</span>

  <br />
  <hr />

  <ul>
    <li v-for="nome in estado.nomes">{{ nome }}</li>
  </ul>
  <input @keyup="evento => estado.nomeAInserir = evento.target.value" placeholder="Cadastrar novo nome" />
  <button @click="cadastraNome()" type="button">Cadastrar</button>
</template>

<style scoped>
img {
  max-width: 200px;
}

.invalido {
  outline-color: red;
  border-color: red;
  background-color: pink;
}
</style>

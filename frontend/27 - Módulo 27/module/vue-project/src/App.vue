<script setup>
import { reactive } from 'vue';

  const estado = reactive({
    filtro: 'todas',
    tarefaTemp : '',
    tarefas: [
      {
        titulo: 'Estudar ES6',
        finalizada: false,
      },
      {
        titulo: 'Estudar Vue',
        finalizada: false,
      },
      {
        titulo: 'Estudar React',
        finalizada: true,
      },
    ],
  });

  const getTarefasPendentes = () => {
    return estado.tarefas.filter((tarefa) => !tarefa.finalizada);
  };

  const getTarefasFinalizadas = () => {
    return estado.tarefas.filter((tarefa) => tarefa.finalizada);
  };

  const getTarefasFiltradas = () => {
    const { filtro } = estado;

    switch (filtro) {
      case 'todas':
        return estado.tarefas;
      case 'pendentes':
        return getTarefasPendentes();
      case 'finalizadas':
        return getTarefasFinalizadas();
      default:
        return estado.tarefas;
    }
  }

  const adicionaTarefa = () => {
    const tarefaNova = {
      titulo: estado.tarefaTemp,
      finalizada: false,
    };
    
    estado.tarefas.push(tarefaNova);
    estado.tarefaTemp = '';
  };
</script>

<template>
  <div class="container">
    <header class="p-5 mb-4 bg-light rounded-3">
      <h1>Minhas Tarefas</h1>
      <p>Você possui {{ getTarefasPendentes().length }} tarefas pendentes</p>
    </header>
    <form @submit.prevent="adicionaTarefa">
      <div class="row">
        <div class="col">
          <input :value="estado.tarefaTemp" @change="evento => estado.tarefaTemp = evento.target.value" required type="text" placeholder="Digite aqui a descrição da tarefa" class="form-control" />
        </div>
        <div class="col-md-1">
          <button type="submit" class="btn btn-primary">Adicionar</button>
        </div>
        <div class="col-md-2">
          <select @change="evento => estado.filtro = evento.target.value" class="form-control">
            <option value="todas">Todas tarefas</option>
            <option value="pendentes">Pendentes</option>
            <option value="finalizadas">Finalizadas</option>
          </select>
        </div>
      </div>
    </form>
    <ul class="list-group mt-4">
      <li class="list-group-item" v-for="tarefa in getTarefasFiltradas()">
        <input  @change="evento => tarefa.finalizada = evento.target.checked" :checked="tarefa.finalizada" :id="tarefa.titulo" type="checkbox" class="mr-2" />
        <label :class="{done: tarefa.finalizada}" class="ms-3" :for="tarefa.titulo">{{ tarefa.titulo }}</label>
      </li>
    </ul>
  </div>
</template>

<style scoped>

  .done {
    text-decoration: line-through;
  }

</style>

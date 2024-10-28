<script setup>
import { reactive } from 'vue';
import Cabecalho from './components/Cabecalho.vue';
import Formulario from './components/Formulario.vue';
import ListaDeTarefas from './components/ListaDeTarefas.vue';

  const estado = reactive({
    filtro: 'todas',
    tarefaTemp : '',
    tarefas: [
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
    <Cabecalho :tarefas-pendentes="getTarefasPendentes().length" />

    <Formulario :trocar-filtro="evento => estado.filtro = evento.target.value" :tarefa-temp="estado.tarefaTemp" :edita-tarefa-temp="evento => estado.tarefaTemp = evento.target.value" :adiciona-tarefa="adicionaTarefa" />

    <ListaDeTarefas :tarefas="getTarefasFiltradas()" v-if="getTarefasFiltradas().length !== 0"/>

    <p v-else-if="estado.filtro === 'pendentes' && getTarefasFiltradas('pendentes').length === 0" class="text-center mt-4">Não há tarefas pendentes.</p>
    <p v-else-if="estado.filtro === 'finalizadas' && getTarefasFiltradas('finalizadas').length === 0" class="text-center mt-4">Não há tarefas finalizadas.</p>
    <p v-else class="text-center mt-4">Não há tarefas. Por favor, adicione alguma.</p>

  </div>
</template>


<script setup>
const props = defineProps(['adicionaTarefa', 'tarefaTemp', 'trocarFiltro', 'editaTarefaTemp']);
</script>

<template>
    <form @submit.prevent="props.adicionaTarefa">
        <div class="row">
            <div class="col">
                <input :value="props.tarefaTemp" @change="props.editaTarefaTemp" required
                    type="text" placeholder="Digite aqui a descrição da tarefa" class="form-control" />
            </div>
            <div class="col-md-1">
                <button type="submit" class="btn btn-primary">Adicionar</button>
            </div>
            <div class="col-md-2">
                <select @change="props.trocarFiltro" class="form-control">
                    <option value="todas">Todas tarefas</option>
                    <option value="pendentes">Pendentes</option>
                    <option value="finalizadas">Finalizadas</option>
                </select>
            </div>
        </div>
    </form>
</template>
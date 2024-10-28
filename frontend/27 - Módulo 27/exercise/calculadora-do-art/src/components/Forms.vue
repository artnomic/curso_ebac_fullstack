<script setup>
    const props = defineProps(['getSelect', 'valueA', 'valueB', 'editValueA', 'editValueB']);
</script>

<template>
    <div class="d-flex justify-content-center">
        <input :value="props.valueA" @input="props.editValueA" required type="text" placeholder="Digite o Primeiro valor" class="form-control w-50 d-flex">
        <input :value="props.valueB" @input="props.editValueB" type="text" placeholder="Digite o Segundo valor" class="form-control w-50 d-flex">

        <select @change="props.getSelect" name="operacao" id="operacao" class="form-select text-center w-25">
            <option value="soma">Soma</option>
            <option value="subtração">Subtração</option>
            <option value="multiplicação">Multiplicação</option>
            <option value="divisão">Divisão</option>
        </select>
    </div>
</template>
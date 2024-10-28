<script setup>
    const props = defineProps(['totalValue']);
</script>

<template>
    <div class="p-2 mt-4 mb-4 text-center">
        <h3>Resultado da operação</h3>
        <p class="position-relative top-50 start-50 translate-middle mt-5 p-3 w-25 border border-primary border-3 rounded-3">
            {{ props.totalValue }}
        </p>
    </div>
</template>

<style scoped>
.done {
    text-decoration: line-through;
}
</style>
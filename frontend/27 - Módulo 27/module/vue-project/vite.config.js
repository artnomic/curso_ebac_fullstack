import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    watch: {
      // Usa polling para evitar atingir o limite de file watchers do sistema
      usePolling: true,
      interval: 1000, // Ajusta o intervalo para verificar mudanças nos arquivos
    },
  },
})

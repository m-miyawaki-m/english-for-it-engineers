import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path'

export default defineConfig({
  base: '/english-for-it-engineers/',
  plugins: [vue()],
  resolve: {
    alias: {
      '@data': resolve(__dirname, '../docs/references')
    }
  }
})

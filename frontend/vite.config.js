import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import path from 'path-browserify';

export default defineConfig({
  plugins: [vue()],
  define: {
    'process.env': {},
  },
  resolve: {
    alias: {
      '@': path.resolve('src'),
    },
  },
  server:{
    port:3000
  }
});


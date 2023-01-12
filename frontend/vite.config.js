import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import AutoImport from 'unplugin-auto-import/vite';
import path from 'path-browserify';

export default defineConfig({
  plugins: [
      vue(),
      AutoImport({
        imports:['vue','vue-router','pinia']
      })
  ],
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


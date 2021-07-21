<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- Vue componets are coded in kabob-case when used in the HTML -->
    <!-- kabob-case is name in all lowercase with - between the maint parts -->
    <!-- using kabob-case makes it easier to distinguish Vue components from normal HTML tags -->
    <product-review/>  <!-- using a Vue component called ProductReview.vue -->
    
  </div>
</template>

<script>

import ProductReview from './components/ProductReview.vue'

export default {
  name: 'App',
  components: {
    ProductReview
    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

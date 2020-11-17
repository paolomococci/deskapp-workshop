<template>
  <div class="home">
    <welcome titleOfPage="welcome to this example of Vue.js frontend web application"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Home',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

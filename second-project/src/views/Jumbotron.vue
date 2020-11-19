<template>
  <div>
    <welcome titleOfPage="jumbotron todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Jumbotron',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

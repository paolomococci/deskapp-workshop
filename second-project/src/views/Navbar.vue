<template>
  <div>
    <welcome titleOfPage="navbar todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Navbar',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

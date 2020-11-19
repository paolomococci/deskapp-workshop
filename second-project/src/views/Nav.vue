<template>
  <div>
    <welcome titleOfPage="nav todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Nav',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

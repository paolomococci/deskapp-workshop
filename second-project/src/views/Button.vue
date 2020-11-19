<template>
  <div>
    <welcome titleOfPage="button todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Button',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

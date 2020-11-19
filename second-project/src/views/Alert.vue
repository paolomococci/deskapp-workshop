<template>
  <div>
    <welcome titleOfPage="alert todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Alert',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

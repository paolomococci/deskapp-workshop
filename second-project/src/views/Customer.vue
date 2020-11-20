<template>
  <div>
    <welcome titleOfPage="customer view todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Customer',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

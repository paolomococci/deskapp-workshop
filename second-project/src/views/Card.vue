<template>
  <div>
    <welcome titleOfPage="card todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Card',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

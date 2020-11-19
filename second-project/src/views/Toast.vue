<template>
  <div>
    <welcome titleOfPage="toast todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Toast',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

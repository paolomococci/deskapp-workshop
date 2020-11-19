<template>
  <div>
    <welcome titleOfPage="modal todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Modal',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

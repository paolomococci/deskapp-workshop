<template>
  <div>
    <welcome titleOfPage="sidebar todo"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'Sidebar',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

<template>
  <div class="about">
    <welcome titleOfPage="about page of this second project"/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'

export default {
  name: 'About',
  components: {
    welcome: WelcomeComponent
  }
}
</script>

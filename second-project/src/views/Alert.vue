<template>
  <div>
    <welcome titleOfPage="alert example"/>
    <alert/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import AlertExampleComponent from '@/components/AlertExampleComponent'

export default {
  name: 'Alert',
  components: {
    welcome: WelcomeComponent,
    alert: AlertExampleComponent
  }
}
</script>

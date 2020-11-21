<template>
  <div>
    <welcome titleOfPage="alert example"/>
    <alertExample/>
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
    alertExample: AlertExampleComponent
  }
}
</script>

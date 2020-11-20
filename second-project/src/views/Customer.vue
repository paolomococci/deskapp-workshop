<template>
  <div>
    <welcome titleOfPage="customer view todo"/>
    <retrieve/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import RetrieveExampleComponent from '@/components/RetrieveExampleComponent'

export default {
  name: 'Customer',
  components: {
    welcome: WelcomeComponent,
    retrieve: RetrieveExampleComponent
  }
}
</script>

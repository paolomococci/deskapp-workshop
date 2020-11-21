<template>
  <div>
    <welcome titleOfPage="example of time picker"/>
    <exampleOfTime/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import TimeExampleComponent from '@/components/TimeExampleComponent'

export default {
  name: 'Time',
  components: {
    welcome: WelcomeComponent,
    exampleOfTime: TimeExampleComponent
  }
}
</script>

<template>
  <div>
    <welcome titleOfPage="example of many buttons"/>
    <exampleOfButton/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import ButtonExampleComponent from '@/components/ButtonExampleComponent'

export default {
  name: 'Button',
  components: {
    welcome: WelcomeComponent,
    exampleOfButton: ButtonExampleComponent
  }
}
</script>

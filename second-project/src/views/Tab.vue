<template>
  <div>
    <welcome titleOfPage="example of vertical tabs"/>
    <exampleOfTab/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import TabExampleComponent from '@/components/TabExampleComponent'

export default {
  name: 'Tab',
  components: {
    welcome: WelcomeComponent,
    exampleOfTab: TabExampleComponent
  }
}
</script>

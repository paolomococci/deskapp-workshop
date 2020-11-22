<template>
  <div>
    <welcome titleOfPage="examples of two tooltip type"/>
    <exampleOfTooltip/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import TooltipExampleComponent from '@/components/TooltipExampleComponent'

export default {
  name: 'Tooltip',
  components: {
    welcome: WelcomeComponent,
    exampleOfTooltip: TooltipExampleComponent
  }
}
</script>

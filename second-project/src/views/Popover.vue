<template>
  <div>
    <welcome titleOfPage="example of popover"/>
    <exampleOfPopover/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import PopoverExampleComponent from '@/components/PopoverExampleComponent'

export default {
  name: 'Popover',
  components: {
    welcome: WelcomeComponent,
    exampleOfPopover: PopoverExampleComponent
  }
}
</script>

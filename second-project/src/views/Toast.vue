<template>
  <div>
    <welcome titleOfPage="examples of some toast components"/>
    <exampleOfToast/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import ToastExampleComponent from '@/components/ToastExampleComponent'

export default {
  name: 'Toast',
  components: {
    welcome: WelcomeComponent,
    exampleOfToast: ToastExampleComponent
  }
}
</script>

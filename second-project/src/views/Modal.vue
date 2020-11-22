<template>
  <div>
    <welcome titleOfPage="example of modal"/>
    <exampleOfModal/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import ModalExampleComponent from '@/components/ModalExampleComponent'

export default {
  name: 'Modal',
  components: {
    welcome: WelcomeComponent,
    exampleOfModal: ModalExampleComponent
  }
}
</script>

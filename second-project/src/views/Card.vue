<template>
  <div>
    <welcome titleOfPage="example of cards"/>
    <exampleOfCard/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import CardExampleComponent from '@/components/CardExampleComponent'

export default {
  name: 'Card',
  components: {
    welcome: WelcomeComponent,
    exampleOfCard: CardExampleComponent
  }
}
</script>

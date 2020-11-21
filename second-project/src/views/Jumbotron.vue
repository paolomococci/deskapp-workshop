<template>
  <div>
    <welcome titleOfPage="example of jumbotron"/>
    <exampleOfJumbotron/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import JumbotronExampleComponent from '@/components/JumbotronExampleComponent'

export default {
  name: 'Jumbotron',
  components: {
    welcome: WelcomeComponent,
    exampleOfJumbotron: JumbotronExampleComponent
  }
}
</script>

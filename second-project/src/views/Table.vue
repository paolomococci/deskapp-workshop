<template>
  <div>
    <welcome titleOfPage="example of table"/>
    <exampleOfTable/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import TableExampleComponent from '@/components/TableExampleComponent'

export default {
  name: 'Table',
  components: {
    welcome: WelcomeComponent,
    exampleOfTable: TableExampleComponent
  }
}
</script>

<template>
  <div>
    <welcome titleOfPage="example of pagination"/>
    <exampleOfPagination/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import PaginationExampleComponent from '@/components/PaginationExampleComponent'

export default {
  name: 'Pagination',
  components: {
    welcome: WelcomeComponent,
    exampleOfPagination: PaginationExampleComponent
  }
}
</script>

<template>
  <div>
    <welcome titleOfPage="example of breadcrumb"/>
    <exampleOfBreadcrumb/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import BreadcrumbExampleComponent from '@/components/BreadcrumbExampleComponent'

export default {
  name: 'Breadcrumb',
  components: {
    welcome: WelcomeComponent,
    exampleOfBreadcrumb: BreadcrumbExampleComponent
  }
}
</script>

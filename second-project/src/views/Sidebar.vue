<template>
  <div>
    <welcome titleOfPage="example of sidebar"/>
    <exampleOfSidebar/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import SidebarExampleComponent from '@/components/SidebarExampleComponent'

export default {
  name: 'Sidebar',
  components: {
    welcome: WelcomeComponent,
    exampleOfSidebar: SidebarExampleComponent
  }
}
</script>

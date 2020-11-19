<template>
  <div>
    <welcome titleOfPage="navbar todo"/>
    <navbar/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import NavbarComponent from '@/components/NavbarComponent'

export default {
  name: 'Navbar',
  components: {
    navbar: NavbarComponent,
    welcome: WelcomeComponent
  }
}
</script>

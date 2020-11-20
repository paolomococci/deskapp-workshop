<template>
  <div>
    <welcome titleOfPage="statistical survey example"/>
    <preference/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import PreferenceComponent from '@/components/PreferenceComponent'

export default {
  name: 'Preference',
  components: {
    welcome: WelcomeComponent,
    preference: PreferenceComponent
  }
}
</script>

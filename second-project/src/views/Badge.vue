<template>
  <div>
    <welcome titleOfPage="examples of some badge components"/>
    <exampleOfBadge/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import BadgeExampleComponent from '@/components/BadgeExampleComponent'

export default {
  name: 'Badge',
  components: {
    welcome: WelcomeComponent,
    exampleOfBadge: BadgeExampleComponent
  }
}
</script>

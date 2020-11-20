<template>
  <div>
    <welcome titleOfPage="example of avatar type buttons"/>
    <avatar/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import AvatarExampleComponent from '@/components/AvatarExampleComponent'

export default {
  name: 'Avatar',
  components: {
    welcome: WelcomeComponent,
    avatar: AvatarExampleComponent
  }
}
</script>

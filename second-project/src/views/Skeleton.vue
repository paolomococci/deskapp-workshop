<template>
  <div>
    <welcome titleOfPage="example of skeleton"/>
    <exampleOfSkeleton/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import SkeletonExampleComponent from '@/components/SkeletonExampleComponent'

export default {
  name: 'Skeleton',
  components: {
    welcome: WelcomeComponent,
    exampleOfSkeleton: SkeletonExampleComponent
  }
}
</script>

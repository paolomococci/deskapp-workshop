<template>
  <div>
    <welcome titleOfPage="example of calendar picker"/>
    <exampleOfCalendar/>
  </div>
</template>

<style>

</style>

<script>
import WelcomeComponent from '@/components/WelcomeComponent'
import CalendarExampleComponent from '@/components/CalendarExampleComponent'

export default {
  name: 'Calendar',
  components: {
    welcome: WelcomeComponent,
    exampleOfCalendar: CalendarExampleComponent
  }
}
</script>

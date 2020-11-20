<template>
  <div>
    <!-- TODO -->
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'ButtonExampleComponent',
  data: () => ({
    grain: false,
    buttons: []
  }),
  methods: {
    // TODO
  },
  computed: {
    buttonStates () {
      return this.buttons.map(button => button.state)
    }
  }
}
</script>

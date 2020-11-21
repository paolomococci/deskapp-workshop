<template>
  <div>
    <div>
      <h5 class="mt-3">single button</h5>
      <b-button :pressed.sync="booleanValueOfAbleButton" variant="primary">able</b-button>
      <p>able state: <strong>{{booleanValueOfAbleButton}}</strong></p>

      <h5>button group</h5>
      <b-button-group size="sm">
        <b-button
          v-for="(button, index) in buttons"
          :key="index"
          :pressed.sync="button.state"
          variant="primary">
          {{button.caption}}
        </b-button>
      </b-button-group>
      <p>able states: <strong>{{buttonStates}}</strong></p>
    </div>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'ButtonExampleComponent',
  data: () => ({
    booleanValueOfAbleButton: false,
    buttons: [
      { caption: 'create', state: false },
      { caption: 'read', state: false },
      { caption: 'update', state: false },
      { caption: 'delete', state: false }
    ]
  }),
  computed: {
    buttonStates () {
      return this.buttons.map(button => button.state)
    }
  }
}
</script>

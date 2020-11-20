<template>
  <div>
    <!-- alert -->
    <b-alert
      :show="countDown"
      dismissible
      variant="info"
      @dismissed="countDown=0"
      @dismiss-count-down="countDownChanged">
      <p>this informational notice will automatically close afterwards {{countDown}} seconds</p>
      <b-progress
        variant="info"
        :max="messageDisplayTimeInSeconds"
        :value="countDown"
        height="5px"></b-progress>
    </b-alert>
    <!-- button -->
    <b-button @click="showAlert" variant="info" class="m-1">
      show info alert
    </b-button>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'AlertExampleComponent',
  data () {
    return {
      messageDisplayTimeInSeconds: 3,
      countDown: 0
    }
  },
  methods: {
    countDownChanged (countDown) {
      this.countDown = countDown
    },
    showAlert () {
      this.countDown = this.messageDisplayTimeInSeconds
    }
  }
}
</script>

<template>
  <div>
    <b-row>
      <b-col md="auto">
        <b-time v-model="value" locale="en" @context="setContext"></b-time>
      </b-col>
      <b-col>
        <p>Value: <em>'{{value}}'</em></p>
        <p class="mb-0">contextual values:</p>
        <pre class="small">{{context}}</pre>
      </b-col>
    </b-row>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'TimeExampleComponent',
  data: () => ({
    value: '',
    context: null
  }),
  methods: {
    setContext (context) {
      this.context = context
    }
  },
  computed: {

  }
}
</script>

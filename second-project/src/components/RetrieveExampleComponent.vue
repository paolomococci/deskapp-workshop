<template>
  <div>
    <!--h3>{{customers}}</h3-->
  </div>
</template>

<style>

</style>

<script>

export default {
  name: 'RetrieveExampleComponent',
  data: () => ({
    customers: null
  }),
  mounted () {
    // axios.get('http://127.0.0.1:8080/customers').then(response => (this.customers = response));
  },
  activated () {
    // TODO
  },
  deactivated () {
    // TODO
  },
  destroyed () {
    // TODO
  },
  props: {
    // TODO
  },
  watch: {
    // TODO
  },
  methods: {
    // TODO
  },
  computed: {
    // TODO
  }
}
</script>

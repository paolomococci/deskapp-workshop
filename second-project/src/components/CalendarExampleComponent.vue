<template>
  <div>
    <b-row>
      <b-col md="auto">
        <b-calendar v-model="value" @context="onContext" locale="it-IT"></b-calendar>
      </b-col>
      <b-col>
        <p>value: <em>{{value}}</em></p>
        <p class="mb-0">context</p>
        <pre class="small">{{context}}</pre>
      </b-col>
    </b-row>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'CalendarExampleComponent',
  data: () => ({
    value: '',
    context: null
  }),
  methods: {
    onContext (contextOfCalendar) {
      this.context = contextOfCalendar
    }
  }
}
</script>

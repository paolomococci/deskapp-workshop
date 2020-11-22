<template>
  <div>
    <b-button v-b-toggle.sidebar-01>show sidebar</b-button>
    <b-sidebar id="sidebar-01" title="example of sidebar" shadow>
      <div class="px-3 py-2">
        <p>example of text into sidebar</p>
      </div>
    </b-sidebar>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'SidebarExampleComponent',
  data: () => ({
    // TODO
  }),
  methods: {
    // TODO
  },
  computed: {
    // TODO
  }
}
</script>

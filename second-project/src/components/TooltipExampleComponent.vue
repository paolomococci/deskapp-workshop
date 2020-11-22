<template>
  <div class="text-center my-3">
    <b-button v-b-tooltip.hover title="tooltip directive content type">
      directive
    </b-button>
    <span> &#173; </span>
    <b-button id="tooltip-01">
      component
    </b-button>
    <b-tooltip target="tooltip-01" triggers="hover">
      tooltip <em>component</em> content type
    </b-tooltip>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'TooltipExampleComponent',
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

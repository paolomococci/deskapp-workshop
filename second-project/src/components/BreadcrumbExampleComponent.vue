<template>
  <div>
    <b-breadcrumb :items="items"></b-breadcrumb>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'BreadcrumbExampleComponent',
  data: () => ({
    items: [
      {
        text: 'webapp',
        href: '#'
      },
      {
        text: 'src',
        href: '#'
      },
      {
        text: 'components',
        active: true
      }
    ]
  }),
  methods: {
    // TODO
  },
  computed: {
    // TODO
  }
}
</script>

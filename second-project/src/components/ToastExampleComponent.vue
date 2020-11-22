<template>
  <div>
    <b-button @click="showToast()" class="mb-2">default variant</b-button>
    <br/>
    <b-button variant="primary" @click="showToast('primary')" class="mb-2">primary variant</b-button>
    <br/>
    <b-button variant="secondary" @click="showToast('secondary')" class="mb-2">secondary variant</b-button>
    <br/>
    <b-button variant="danger" @click="showToast('danger')" class="mb-2">danger variant</b-button>
    <br/>
    <b-button variant="warning" @click="showToast('warning')" class="mb-2">warning variant</b-button>
    <br/>
    <b-button variant="success" @click="showToast('success')" class="mb-2">success variant</b-button>
    <br/>
    <b-button variant="info" @click="showToast('info')" class="mb-2">info variant</b-button>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'ToastExampleComponent',
  data: () => ({
    // TODO
  }),
  methods: {
    showToast (variant = null) {
      this.$bvToast.toast('some content of this variant component', {
        title: `tast example with variant: ${variant || 'default'}`,
        variant: variant,
        solid: true
      })
    }
  },
  computed: {
    // TODO
  }
}
</script>

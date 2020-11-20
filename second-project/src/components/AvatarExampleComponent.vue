<template>
  <div class="mb-2">
  <b-list-group>
    <b-list-group-item>
      <b-avatar button @click="showInfo" variant="primary" text="jd" class="align-baseline"></b-avatar>
      avatar button with first and last name initials
    </b-list-group-item>
    <b-list-group-item>
      <b-avatar button @click="showInfo" src="#"></b-avatar>
      icon type avatar button
    </b-list-group-item>
    <b-list-group-item>
      <b-avatar button @click="showInfo" icon="star-fill" class="align-center"></b-avatar>
      icon type avatar button
    </b-list-group-item>
  </b-list-group>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'AvatarExampleComponent',
  methods: {
    showInfo () {
      this.$bvModal.msgBoxOk('user name: John Doe', {
        title: 'user name info',
        okVariant: 'success',
        headerClass: 'p-2 border-bottom-0',
        footerClass: 'p-2 border-top-0'
      })
    }
  }
}
</script>

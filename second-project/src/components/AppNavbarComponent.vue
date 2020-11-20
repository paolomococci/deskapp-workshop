<template>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">
      <b-avatar size="4em" rounded>second<br>project</b-avatar>
    </b-navbar-brand>
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item to="/">home</b-nav-item>
        <b-nav-item to="/about">about</b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="search"></b-form-input>
          <b-button size="sm" class="my-2 my-sm-0" type="submit">search</b-button>
        </b-nav-form>
        <b-nav-item-dropdown right>
          <template #button-content>
            <em>forms</em>
          </template>
          <b-dropdown-item to="/preference">preference</b-dropdown-item>
        </b-nav-item-dropdown>
        <b-nav-item-dropdown right>
          <template #button-content>
            <em>examples</em>
          </template>
          <b-dropdown-item to="/alert">alert</b-dropdown-item>
          <b-dropdown-item to="/avatar">avatar</b-dropdown-item>
          <b-dropdown-item to="/badge">badge</b-dropdown-item>
          <b-dropdown-item to="/breadcrumb">breadcrumb</b-dropdown-item>
          <b-dropdown-item to="/button">button</b-dropdown-item>
          <b-dropdown-item to="/calendar">calendar</b-dropdown-item>
          <b-dropdown-item to="/card">card</b-dropdown-item>
          <b-dropdown-item to="form">form</b-dropdown-item>
          <b-dropdown-item to="/jumbotron">jumbotron</b-dropdown-item>
          <b-dropdown-item to="/modal">modal</b-dropdown-item>
          <b-dropdown-item to="/nav">nav</b-dropdown-item>
          <b-dropdown-item to="/navbar">navbar</b-dropdown-item>
          <b-dropdown-item to="/pagination">pagination</b-dropdown-item>
          <b-dropdown-item to="/popover">popover</b-dropdown-item>
          <b-dropdown-item to="/sidebar">sidebar</b-dropdown-item>
          <b-dropdown-item to="/skeleton">skeleton</b-dropdown-item>
          <b-dropdown-item to="/tab">tab</b-dropdown-item>
          <b-dropdown-item to="/table">table</b-dropdown-item>
          <b-dropdown-item to="/time">time</b-dropdown-item>
          <b-dropdown-item to="/toast">toast</b-dropdown-item>
          <b-dropdown-item to="/tooltip">tootip</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<style>

</style>

<script>
export default {
  name: 'AppNavbarComponent',
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

<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand href="#">second project</b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#">about</b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-form>
            <b-form-input size="sm" class="mr-sm-2" placeholder="search"></b-form-input>
            <b-button size="sm" class="my-2 my-sm-0" type="submit">search</b-button>
          </b-nav-form>
          <b-nav-item-dropdown right>
            <template #button-content>
              <em>examples</em>
            </template>
            <b-dropdown-item href="#">alert</b-dropdown-item>
            <b-dropdown-item href="#">avatar</b-dropdown-item>
            <b-dropdown-item href="#">badge</b-dropdown-item>
            <b-dropdown-item href="#">breadcrumb</b-dropdown-item>
            <b-dropdown-item href="#">button</b-dropdown-item>
            <b-dropdown-item href="#">calendar</b-dropdown-item>
            <b-dropdown-item href="#">card</b-dropdown-item>
            <b-dropdown-item href="#">form</b-dropdown-item>
            <b-dropdown-item href="#">jumbotron</b-dropdown-item>
            <b-dropdown-item href="#">modal</b-dropdown-item>
            <b-dropdown-item href="#">navbar</b-dropdown-item>
            <b-dropdown-item href="#">nav</b-dropdown-item>
            <b-dropdown-item href="#">pagination</b-dropdown-item>
            <b-dropdown-item href="#">popover</b-dropdown-item>
            <b-dropdown-item href="#">sidebar</b-dropdown-item>
            <b-dropdown-item href="#">skeleton</b-dropdown-item>
            <b-dropdown-item href="#">tab</b-dropdown-item>
            <b-dropdown-item href="#">table</b-dropdown-item>
            <b-dropdown-item href="#">time</b-dropdown-item>
            <b-dropdown-item href="#">toast</b-dropdown-item>
            <b-dropdown-item href="#">tootip</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'NavbarComponent',
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

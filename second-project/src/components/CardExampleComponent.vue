<template>
  <div>
    <b-card-group deck>
      <b-card
        header="some header"
        header-tag="header"
        footer="some footer"
        footer-tag="footer"
        title="some title">
        <b-card-text>example of simply text</b-card-text>
        <b-button href="#" variant="primary">somewhere</b-button>
      </b-card>
      <b-card title="some title" header-tag="header" footer-tag="footer">
        <template #header>
          <h6 class="mb-0">header</h6>
        </template>
        <b-card-text>example of text content</b-card-text>
        <b-button href="#" variant="primary">somewhere</b-button>
        <template #footer>
          <em>footer</em>
        </template>
      </b-card>
    </b-card-group>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'CardExampleComponent'
}
</script>

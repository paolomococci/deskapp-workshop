<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <!-- email -->
      <b-form-group
        id="input-email"
        label="email:"
        label-for="label-input-email"
        description="we'll never share your email with anyone else">
        <b-form-input
          id="label-input-email"
          v-model="personalDataForm.email"
          type="email"
          required
          placeholder="please, enter your email">
        </b-form-input>
      </b-form-group>
      <!-- name -->
      <b-form-group id="input-name" label="name:" label-for="label-input-name">
        <b-form-input
          id="label-input-name"
          v-model="personalDataForm.name"
          required
          placeholder="please, enter your name">
        </b-form-input>
      </b-form-group>
      <!-- surname -->
      <b-form-group id="input-surname" label="surname:" label-for="label-input-surname">
        <b-form-input
          id="label-input-surname"
          v-model="personalDataForm.surname"
          required
          placeholder="please, enter your family name">
        </b-form-input>
      </b-form-group>
      <!-- fruit -->
      <b-form-group id="input-fruit" label="fruits:" label-for="label-input-fruit">
        <b-form-select
          id="label-input-fruit"
          v-model="personalDataForm.fruit"
          :options="fruits"
          required>
        </b-form-select>
      </b-form-group>
      <!-- checks -->
      <b-form-group id="input-checks">
        <b-form-checkbox-group v-model="personalDataForm.checked" id="checkboxes-checks">
          <b-form-checkbox value="me">check me out</b-form-checkbox>
          <b-form-checkbox value="that">check that out</b-form-checkbox>
        </b-form-checkbox-group>
      </b-form-group>
      <!-- submit or reset form -->
      <b-button type="submit" variant="primary">submit</b-button>
      <span> &#173; </span>
      <b-button type="reset" variant="danger">reset</b-button>
    </b-form>
      <!-- form data result view -->
    <b-card class="mt-3" title="json data result view:">
      <pre class="m-0">{{personalDataForm}}</pre>
    </b-card>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'PreferenceComponent',
  data: () => ({
    personalDataForm: {
      email: '',
      name: '',
      surname: '',
      fruit: null,
      checked: []
    },
    fruits: [
      { text: 'select your preferred fruit:', value: null }, 'apple', 'banana', 'blueberry', 'cherry', 'currant', 'grapes', 'orange', 'pear', 'plum', 'strawberry'
    ],
    show: true
  }),
  methods: {
    onSubmit (event) {
      event.preventDefault()
      alert(JSON.stringify(this.personalDataForm))
    },
    onReset (event) {
      event.preventDefault()
      this.personalDataForm.email = ''
      this.personalDataForm.name = ''
      this.personalDataForm.surname = ''
      this.personalDataForm.fruit = null
      this.personalDataForm.checked = []
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    }
  },
  computed: {
    // TODO
  }
}
</script>

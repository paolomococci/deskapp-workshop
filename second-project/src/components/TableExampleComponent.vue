<template>
  <div>
    <b-table striped hover :items="items" :fields="fields"></b-table>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'TableExampleComponent',
  data: () => ({
    fields: ['name', 'surname', 'age'],
    items: [
      { age: 34, name: 'John', surname: 'Feed' },
      { age: 23, name: 'Zoe', surname: 'Write' },
      { age: 33, name: 'Liz', surname: 'Jump' },
      { age: 32, name: 'Robert', surname: 'Learn' }
    ]
  })
}
</script>

<template>
  <div>
    <div class="overflow-auto">
      <b-pagination
        v-model="currentView"
        :total-rows="getRow"
        :per-page="perPage"
        first-text="first"
        prev-text="prev"
        next-text="next"
        last-text="last"
        aria-controls="table-01">
      </b-pagination>
      <p class="mt-3"><em>current view:</em> {{currentView}}</p>
      <b-table
        id="table-01"
        :items="items"
        :per-page="perPage"
        :current-page="currentView"
        small>
      </b-table>
    </div>
  </div>
</template>

<style>

</style>

<script>
export default {
  name: 'PaginationExampleComponent',
  data: () => ({
    perPage: 5,
    currentView: 1,
    items: [
      { id: 13, name: 'Mary', surname: 'Bid' },
      { id: 5, name: 'Shirley', surname: 'Dare' },
      { id: 15, name: 'Zoe', surname: 'Gild' },
      { id: 12, name: 'Lisa', surname: 'Go' },
      { id: 3, name: 'Lily', surname: 'Knit' },
      { id: 7, name: 'Athena', surname: 'Know' },
      { id: 10, name: 'Liz', surname: 'Lay' },
      { id: 9, name: 'Geo', surname: 'Mean' },
      { id: 11, name: 'Jinger', surname: 'Read' },
      { id: 8, name: 'Hop', surname: 'Rend' },
      { id: 1, name: 'Sophie', surname: 'Strew' },
      { id: 4, name: 'Rebecca', surname: 'Sweep' },
      { id: 6, name: 'Diana', surname: 'Take' },
      { id: 14, name: 'Susan', surname: 'Wring' },
      { id: 2, name: 'Telma', surname: 'Write' }
    ]
  }),
  methods: {
    // TODO
  },
  computed: {
    getRow () {
      return this.items.length
    }
  }
}
</script>

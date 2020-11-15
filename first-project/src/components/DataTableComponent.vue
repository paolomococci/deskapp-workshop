<template>
    <div>
        <v-simple-table dense>
            <template v-slot:default>
                <caption>tastes of ice-cream</caption>
                <thead>
                    <tr>
                        <th class="text-left">
                            taste
                        </th>
                        <th class="text-left">
                            cost
                        </th>
                        <th class="text-left">
                            calories
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="item in items" :key="item.taste">
                        <td>{{item.taste}}</td>
                        <td>{{item.cost}}</td>
                        <td>{{item.calories}}</td>
                    </tr>
                </tbody>
            </template>
        </v-simple-table>
    </div>
</template>

<style>

</style>

<script>
export default {
    
    name: 'DataTableComponent',

    data: () => ({
        items: [
            {
                taste: 'cassata',
                cost: 1.21,
                calories: 205,
            },
            {
                taste: 'triple chocolate',
                cost: 0.98,
                calories: 288,
            },
            {
                taste: 'cream',
                cost: 0.88,
                calories: 210,
            },
            {
                taste: 'yogurt',
                cost: 1.02,
                calories: 188,
            },
            {
                taste: 'coffee',
                cost: 1.05,
                calories: 195,
            },
            {
                taste: 'milk cream',
                cost: 0.76,
                calories: 215,
            },
            {
                taste: 'mint',
                cost: 0.55,
                calories: 212,
            },
            {
                taste: 'lemon',
                cost: 0.75,
                calories: 145,
            },
            {
                taste: 'melon',
                cost: 0.84,
                calories: 150,
            },
            {
                taste: 'cherry',
                cost: 1.01,
                calories: 180,
            },
        ]
    }), 

    props: {
        // TODO
    }
}
</script>

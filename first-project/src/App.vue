<template>
	<v-app>
		<v-app-bar app color="#8c9" dark>
			<div class="d-flex align-center">
				<h2>first project</h2>
			</div>
			<v-spacer></v-spacer>
			<v-btn href="#" target="_blank" text>
				<span class="mr-2">help</span>
				<v-icon>mdi-open-in-new</v-icon>
			</v-btn>
		</v-app-bar>
		<v-main>
			<pm-data-table></pm-data-table>
		</v-main>
	</v-app>
</template>

<script>
import DataTableComponent from './components/DataTableComponent';

export default {
	name: 'App',

	components: {
		'pm-data-table': DataTableComponent
	},

	data: () => ({
		// TODO
	})
};
</script>


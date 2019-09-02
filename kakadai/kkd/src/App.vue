<template>
	<div id="app" class="container-fluid">
		<router-view />
	</div>
</template>

<script>
	export default {
		name: 'App',
		mounted() {
			window.addEventListener('hashchange', () => {
				var currentPath = window.location.hash.slice(1);
				if(this.$router.path !== currentPath) {
					this.$router.push(currentPath);
				}
			})
		}
	}
</script>

<style>
	.container-fluid {
		padding-left: 0px;
		padding-right: 0px;
	}
	/*#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}*/
</style>
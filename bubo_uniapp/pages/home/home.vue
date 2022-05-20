<template>
	<view>
		123
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			async onLoad(options) {
				console.log(uni.getStorageSync('token'));
				this.$request({
					url: "getRouters",
					method:'get',
					success: function (res) {
						console.log(res.data.code);
						console.log(res.data);
					}
				})    
			},
			
		}
	}
</script>

<style>

</style>

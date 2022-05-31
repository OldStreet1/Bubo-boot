<template>
	<view>
		首页
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
				
				//获取菜单
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

<template>
	<view class="c-z-m-body c-z-m-bg-login">
		<view  style="width: 100%;height: 40px;color: #FFFFFF;font-size: 30px;margin-top: 10%;margin-left: 2%;">{{title}}</view>
		<view class="c-z-m-login-bg">
		<view class="loginbar">
			<view class="loginbar-account clear">
				<image class="loginbar-icon" src="../../static/login/loginbar-icon-account.png"></image>
				<input class="c-z-m-input"  type="text" v-model="account" placeholder="请输入账号" placeholder-style="color:#ffffff; caret-color:red;">
			</view>
			<view class="loginbar-password clear">
				<image class="loginbar-icon" src="../../static/login/loginbar-icon-password.png"></image>
				<input class="c-z-m-input"  type="text" password="true" v-model="password" placeholder="请输入密码" placeholder-style="color:#ffffff; caret-color:red;">
			</view>
<!-- 			<view>
				<checkbox-group style="float: right;margin: 16upx 0;" @change="rememberPwdChange">
					<label class="c-z-m-fontsize-14">
						<checkbox value="0" :checked="rememberPwd" />记住密码
					</label>
				</checkbox-group>
			</view> -->
			<view class="login-btn">
				<button type="primary" class="primary" @tap="bindLogin">登录</button>
			</view>
		</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				href: 'https://uniapp.dcloud.io/component/README?id=uniui',
				account: "admin",
				password: "admin1231",
				title:"123333",
			}
		},
		methods: {
			//进入查询openid是否存在
			async onLoad(options) {
				
				var myDate = new Date();
				var hours = myDate.getHours();
				if(hours >= 0 && hours < 3){
					this.title = "夜深了请注意休息"	
				}else if(hours >= 3 && hours < 8){
					this.title = "早起的鸟儿有虫吃"	
				}else if(hours >= 8 && hours < 11){
					this.title = "撸起袖子加油干"	
				}else if(hours >= 11 && hours < 14){
					this.title = "按时吃饭，好好休息"	
				}else if(hours >= 14 && hours < 19){
					this.title = "今天又是美好的一天"	
				}else if(hours >= 19 && hours < 21){
					this.title = "好好加油呦～"	
				}else if(hours >= 21 && hours < 24){
					this.title = "夜深了，注意休息"	
				}
			},
			async bindLogin() {
				
			
				var that = this;
				console.log("登录")
				uni.request({
				    url: this.$url + "wxlogin", 
					method: 'POST',
				    data: {
				        username: that.account,
				        password: that.password,
				    }, 
					dataType:'json',
				    success: (res) => {
				        console.log(res);
						if(res.data.code == 200){
							uni.setStorage({
								key:'token',
								data:res.data.token
							})
							uni.switchTab({
								url: "/pages/home/home",
							});
							
						}else{
							uni.showModal({
								title: "提示",
								showCancel: false,
								content: res.data.msg || "无法连接服务器",
							})
						}
				        // this.text = 'request success';
						
				    }
				});
					
				
			}
		}
	};
	
</script>

<style>
	@import "../../css/master.css";
	@import "../../css/font.css";
	@import "../../css/base.css";

	page{
		background: url(../../static/home/index.jpg) no-repeat;
		background-size: 100% auto;
	}
	.c-z-m-input{
		margin-left: 20px;
	}
</style>

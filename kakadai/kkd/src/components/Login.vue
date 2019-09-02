
<template>
	<div class="container-fluid">
		<div class="login">
			<div class="row">
				<div class="col-xs-12">
					<form class="form-horizontal login-form">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<img width="20px" height="20px" src="../../static/img/login/login_phone.png" />
								</div>
								<input v-on:change="telcheck()" type="text" class="form-control" name="tel" id="tel" v-model="tel" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<span v-if="telchecshowtip" class="tip">
									请输入正确的手机号
								</span>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<img width="20px" height="20px" src="../../static/img/login/login_pass.png" />
								</div>
								<input type="text" class="form-control" name="code" id="code" v-model="code" />
								<div v-on:click="sendcode()" class="input-group-addon send-code">
									{{sendcodetext}}
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<span v-if="tipactive" class="tip">
									验证码输入错误
								</span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10 text-center">
								<button v-on:click="sub()" class="btn btn-default subbtn">注册领钱</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</template>

<script>
	import qs from 'qs'
	export default {
		name: "Login",
		data() {
			return {
				tel: null,
				code: null,
				tipactive: false,
				sendcodetext: "获取验证码",
				telchecshowtip: false
			}
		},
		computed: {

		},
		methods: {
			telcheck: function() {
				var telRegex = /0?(13|14|15|18|17)[0-9]{9}/;
				if(telRegex.test(this.tel)) {
					this.telchecshowtip = false;
					return true;
				} else {
					this.telchecshowtip = true;
				}
				return false;
			},
			sendcode: function() {
				if(this.telcheck() == false) {
					return false;
				}
				if(this.sendcodetext == "验证码已发送") {
					return false;
				} else {
					axios.post('/apis/front/sms/test', qs.stringify({"phone": this.tel})).then((response)=> {
						if(response.status == "200") {
							this.sendcodetext = "验证码已发送";
						} else {
							alert("验证码获取错误，请重试！");
						}
					})
				}

			},
			sub: function() {
				//测试开始
				this.$router.push({
					path: '/step1',
					query: {
						statusnum: "0",
					}
				});
				//测试结束
				axios.post('/apis/front/login/login', {
					phone: this.tel,
					code: this.code
				}).then(function(response) {
					if(response.status == "200") {
						$.cookie("sid", response.data.sid);

						if(response.status != "") {
							this.$router.push({
								path: '/status',
								query: {
									statusnum: response.data.status,
								}
							})
						} else {
							switch(response.step) {
								case "0":
									this.$router.push({
										path: '/step1',
										query: {
											step: response.data.step,
										}
									})
									break;
								case "1":
									this.$router.push({
										path: '/step2',
										query: {
											step: response.data.step,
										}
									})
									break;
								case "2":
									this.$router.push({
										path: '/step3',
										query: {
											step: response.data.step,
										}
									})
									break;
								case "3":
									this.$router.push({
										path: '/step4',
										query: {
											step: response.data.step,
										}
									})
									break;
									//								case "4":
									//									this.$router.push({
									//										path: '/status',
									//										query: {
									//											statusnum: 2,
									//										}
									//									})
									//									break;
								default:
									break;
							}
						}
					} else {
						Login.sendcodetext = "发送验证码";
						alert("验证码错误，请重试！");
					}
				})
			}
		}
	}
</script>

<style scoped="scoped">
	.login {
		background-image: url(../../static/img/login.png);
		background-size: 100% 100%;
		height: 100%;
		margin-bottom: 20%;
		padding-bottom: 20%;
	}
	
	.login-form {
		background-color: #fff;
		margin: 20px;
		padding: 30px;
		margin-top: 100%;
		margin-bottom: 15%;
		border-radius: 20px;
	}
	
	.subbtn {
		background-image: url(../../static/img/login/login_button.png);
		background-size: 100% 100%;
		border: 0px;
		width: 100%;
		font-size: 1.3em;
		padding: 15px;
		padding-bottom: 20px;
		color: #FFFFFF;
	}
	
	.tip {
		color: red;
	}
</style>
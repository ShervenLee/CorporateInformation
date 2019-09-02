<template>
	<div class="step">
		<div class="container-fluid">
			<div class="headcom">
				<div class="row title">
					<div class="col-xs-12">
						运营商认证
					</div>
				</div>
				<div class="row num" id="num">
					<div class="col-xs-3">
						<div>&nbsp;1&nbsp;</div>
					</div>
					<div class="col-xs-3">
						<div>&nbsp;2&nbsp;</div>
					</div>
					<div class="col-xs-3">
						<div>&nbsp;3&nbsp;</div>
					</div>
					<div class="col-xs-3 noactive">
						<div>&nbsp;4&nbsp;</div>
					</div>
				</div>
				<div class="row">
					<br />
				</div>
				<div class="row text">
					<div class="col-xs-3">
						身份认证
					</div>
					<div class="col-xs-3">
						肖像认证
					</div>
					<div class="col-xs-3">
						运营商认证
					</div>
					<div class="col-xs-3 noactive">
						芝麻分认证
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<form class="form-horizontal login-form">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									手机号
								</div>
								<input v-on:change="telcheck()" type="text" class="form-control" placeholder="请输入手机号" name="tel" id="tel" v-model="tel" />
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
									验证码
								</div>
								<input v-on:change="telcheck()" type="text" class="form-control" name="code" id="code" v-model="code" />
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
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<button v-on:click="sub()" class="btn btn-sm btn-block subbtn">下一步</button>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: "Step3",
		data() {
			return {
				tipactive:false,
				sendcodetext: "获取验证码",
				tel:null,
				code:null
			}
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
			sub:function(){
				axios.post('/apis/front/user/step/3', {
					__sid:$.cookie("sid"),
					mobile: this.tel,
					mobilePassword:this.code
				}).then(function(response) {
					if(response.status == "200") {
						this.$router.push({
							path: '/step4',
							query: {
							}
						});
					} else {
						alert("未知错误");
					}
				});
			}
		}
	}
</script>

<style>
	.container {
		padding: 0px;
		margin: 0px;
	}
	
	.headcom {
		background-color: #4F72ED;
		padding: 0px;
		margin: 0px;
		text-align: center;
		width: 100%;
		color: #FFFFFF;
		padding-top: 10%;
		padding-bottom: 5%;
		padding-left: 2%;
		padding-right: 2%;
	}
	
	.headcom .title {
		color: #FFFFFF;
		padding-bottom: 10%;
		font-size: 1.4em;
	}
	
	.headcom .num .col-xs-3 div {
		display: inline-block;
		width: 20px;
		height: 20px;
		line-height: 20px;
		border-radius: 100%;
		color: #4F72ED;
		background-color: #FFFFFF;
	}
	
	.step {
		background-color: #FFFFFF;
		padding-bottom: 20%;
	}
	
	#num>.noactive>div {
		background-color: #C5C5C5;
	}
	.subbtn {
		background-color: #4E6FEC;
		background-color: -webkit-linear-gradient(to right ,rad,blue);
		padding: 10px;
		color: #FFFFFF;
		font-size: 1.2em;
	}
	.tip{
		color: red;
	}
</style>
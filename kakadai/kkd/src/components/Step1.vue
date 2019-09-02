<template>
	<div class="step">
		<div class="container-fluid">
			<div class="headcom">
				<div class="row title">
					<div class="col-xs-12">
						身份认证
					</div>
				</div>
				<div class="row num" id="num">
					<div class="col-xs-3">
						<div>&nbsp;1&nbsp;</div>
					</div>
					<div class="col-xs-3 noactive">
						<div>&nbsp;2&nbsp;</div>
					</div>
					<div class="col-xs-3 noactive">
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
					<div class="col-xs-3 noactive">
						肖像认证
					</div>
					<div class="col-xs-3 noactive">
						运营商认证
					</div>
					<div class="col-xs-3 noactive">
						芝麻分认证
					</div>
				</div>
			</div>
			<div class="row form">
				<div class="col-xs-12">
					<div class="form-group">
						<div class="row">
							<div class="col-xs-4">
								<label><span>*&nbsp;</span>姓名</label>
								<span v-if="nametips">&nbsp;&nbsp;请检查输入是否正确</span>
							</div>
							<div class="col-xs-8">
								<input class="form-control" dir="rtl" type="text" name="name" v-model="name" placeholder="请输入真实姓名" />
							</div>
						</div>
					</div>
					<hr />
				</div>
				<div class="col-xs-12">
					<div class="form-group">
						<div class="row">
							<div class="col-xs-4">
								<label><span>*&nbsp;</span>身份证</label>
								<span v-if="idtips">&nbsp;&nbsp;请检查输入是否正确</span>
							</div>
							<div class="col-xs-8">
								<input class="form-control" dir="rtl" type="text" name="id" v-model="id" placeholder="请输入身份证" />
							</div>
						</div>
					</div>
					<hr />
				</div>
				<div class="col-xs-12">
					<div class="form-group">
						<div class="row">
							<div class="col-xs-4">
								<label><span>*&nbsp;</span>婚姻状况</label>
								<span v-if="marrytips">&nbsp;&nbsp;请检查输入是否正确</span>
							</div>
							<div class="col-xs-8">
								<select v-model="marry" class="form-control">
									<option value="0">未婚</option>
									<option value="1">已婚</option>
								</select>
							</div>
						</div>
					</div>
					<hr />
				</div>
				<div class="col-xs-12">
					<div class="form-group">
						<div class="row">
							<div class="col-xs-4">
								<label><span>*&nbsp;</span>工作单位</label>
								<span v-if="comnametips">&nbsp;&nbsp;请检查输入是否正确</span>
							</div>
							<div class="col-xs-8">
								<input class="form-control" dir="rtl" type="text" name="comname" v-model="comname" placeholder="请输入工作单位" />
							</div>
						</div>
					</div>
					<hr />
				</div>
				<div class="col-xs-12">
					<div class="form-group">
						<div class="row">
							<div class="col-xs-4">
								<label><span>*&nbsp;</span>工作地址</label>
								<span v-if="addresstips">&nbsp;&nbsp;请检查输入是否正确</span>
							</div>
							<div class="col-xs-12">
								<textarea class="form-control" dir="rtl" type="text" name="address" v-model="address" placeholder="请输入工作单位" />
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12">
					<button v-on:click="sub()" class="btn btn-sm btn-block subbtn">下一步</button>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: "Step1",
		data() {
			return {
				name: null,
				id: null,
				marry: 0,
				comname: null,
				address: null
			}
		},
		methods: {
			sub: function() {
				axios.post('/apis/front/user/step/1', {
					__sid:$.cookie("sid"),
					name: this.name,
					idNumber: this.id,
					marriage: this.marry,
					workUnit: this.comname,
					workAddress: this.address
				}).then(function(response) {
					if(response.status == "200") {
						this.$router.push({
							path: '/step2',
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

<style scoped="scoped">
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
		/*background-color: #F4F5F9;*/
		padding-bottom: 20%;
	}
	
	.form {
		padding-left: 10%;
		padding-right: 10%;
		padding-top: 10%;
	}
	
	.form span {
		color: red;
	}
	
	.form * {
		line-height: 15px;
	}
	
	.form input {
		/*border: 1px solid #FFFFFF;*/
		height: 25px;
		outline: none;
		padding: 0px;
		margin: 0px;
	}
	
	.form hr {
		color: red;
		height: 20px;
	}
	
	.subbtn {
		background-color: #4E6FEC;
		padding: 10px;
		color: #FFFFFF;
		font-size: 1.2em;
	}
	
	.noactive {
		color: #C5C5C5;
	}
	
	#num>.noactive>div {
		background-color: #C5C5C5;
	}
</style>
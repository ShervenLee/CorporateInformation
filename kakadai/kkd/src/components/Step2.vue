<template>
	<div class="step">
		<div class="container-fluid">
			<div class="headcom">
				<div class="row title">
					<div class="col-xs-12">
						肖像认证
					</div>
				</div>
				<div class="row num" id="num">
					<div class="col-xs-3">
						<div>&nbsp;1&nbsp;</div>
					</div>
					<div class="col-xs-3">
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
					<div class="col-xs-3">
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
			<div class="text-center">
				<div class="row">
					<div class="col-xs-12">
						<span class="title">─── 照片示例 ───</span>
					</div>
					<div class="col-xs-12">
						<img src="../../static/img/img-head@1.5x.png" />
					</div>
					<div class="col-xs-12">
						<span>
							上传一张胸部以上的人像照片，请参照以上示例。
						<br />
						图片大小不超过2M
						</span>
					</div>
				</div>
			</div>
			<div class="upload text-center row">
				<template v-if="imgurl==null">
					<input style="display: none;" v-on:change="uploadimg" class="btn btn-sm " type="file" name="image" id="image" value="上传" />
					<button v-on:click="uploadbtn()" class="btn btn-sm ">上传</button>
				</template>
				<template v-else>
					<div class="img">
						<img width="auto" height="120px" v-bind:src="imgurl" />
					</div>
				</template>
			</div>
			<div class="col-xs-12">
				<button v-on:click="sub()" class="btn btn-sm btn-block subbtn">下一步</button>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: "Step2",
		data() {
			return {
				imgurl: null
			}
		},
		methods: {
			uploadbtn: function() {
				$("#image").click();
			},
			uploadimg: function() {
				let formData = new FormData();
				formData.append('__sid', this.$.cookie("sid"));
				formData.append('image', this.image);

				const instance = axios.create({
					withCredentials: true
				})
				instance.post('/apis/front/user/upload', formData).then(res => {
					if(res.status == "200") {
						this.imgurl = res.data;
					} else {
						alert("未知错误，请重试！");
					}

				})
			},
			sub: function() {
				axios.post('/apis/front/user/step/2', {
					__sid: $.cookie("sid"),
					photo: this.imgurl
				}).then(function(response) {
					if(response.status == "200") {
						this.$router.push({
							path: '/step3'
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
		background-color: #F4F5F9;
		padding-bottom: 20%;
	}
	
	.subbtn {
		background-color: #4E6FEC;
		background-color: -webkit-linear-gradient(to right, rad, blue);
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
	
	.text-center span {
		display: inline-block;
		margin: 15px;
	}
	
	.text-center .title {
		font-size: 1.3em;
	}
	
	.text-center img {
		width: 50%;
	}
	
	.text-center {
		background-color: #FFFFFF;
		margin-bottom: 15px;
	}
	
	.upload {
		background-color: #FFFFFF;
		padding: 15px;
	}
	
	.upload span {
		line-height: 120px;
	}
	
	.upload button {
		background-color: #588AF7;
		color: #FFFFFF;
		padding: 10px 30px 10px 30px;
		border-radius: 10%;
		font-size: 1.1em;
		margin-top: 40px;
		margin-bottom: 40px;
	}
</style>
<template>
	<div class="status">
		<div class="container-fluid">
			<div class="headcom">
				<div class="row title">
					<div class="col-xs-12">
						{{title}}
					</div>
				</div>
				<div class="row num">
					<div class="col-xs-3">
						<div>&nbsp;1&nbsp;</div>
					</div>
					<div class="col-xs-3">
						<div>&nbsp;2&nbsp;</div>
					</div>
					<div class="col-xs-3">
						<div>&nbsp;3&nbsp;</div>
					</div>
					<div class="col-xs-3">
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
					<div class="col-xs-3">
						芝麻分认证
					</div>
				</div>
			</div>
			<div class="text-center">
				<div class="row">
					<div class="col-xs-12">
						<img v-bind:src="imgurl" />
						<br />
						<span class="title">{{info}}</span>
						<br />
						<span class="des">{{des}}</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<template v-if="status==3">
						<button class="noactive btn btn-sm btn-block subbtn">{{btntext}}</button>
					</template>
					<template v-else>
						<button v-on:click="sub()" class=" btn btn-sm btn-block subbtn">{{btntext}}</button>
					</template>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: "Status",
		data() {
			return {
				status: null,
				imgurl: "",
				title: "",
				info: "",
				des: "",
				btntext: ""
			}
		},
		created() {
			this.status = this.$route.query.statusnum;
		},
		watch: {
			"status": function() {
				switch(this.status) {
					case "0":
						this.title = "审核失败";
						this.imgurl = "../../static/img/examine-icon1@1.5x.png";
						this.info = "审核失败";
						this.des = "请重新提交数据";
						this.btntext = "关闭";
						break;
					case "1":
						this.title = "审核成功";
						this.imgurl = "../../static/img/examine-icon3@1.5x.png";
						this.info = "审核成功";
						this.des = "已经审核成功可以去借款了";
						this.btntext = "去借款";
						break;
					case "2":
						this.title = "审核中";
						this.imgurl = "../../static/img/examine-icon1@1.5x.png";
						this.info = "申请成功，正在审核";
						this.des = "我们将于48小时内完成审核，请耐心等待";
						this.btntext = "急速审核";
						break;
					case "3":
						this.title = "急速审核";
						this.imgurl = "../../static/img/examine-icon1@1.5x.png";
						this.info = "审核成功，正在急速审核";
						this.des = "我们将于1小时内完成审核，请耐心等待";
						this.btntext = "去借款";
						break;
					default:
						break;
				}
			}
		},
		computed: {},
		methods: {
			sub: function() {
				switch(this.status) {
					case "2":
						this.status = "3";
				}
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
	
	.text-center img {
		margin-top: 100px;
		width: 50%;
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
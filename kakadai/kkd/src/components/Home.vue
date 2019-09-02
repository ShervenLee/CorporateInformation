<template>
	<div class="home">
		<div class="container-fluid">
			<div class="headcom">
				<div class="row title">
					<div class="col-xs-12">
						认证
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

			<div class="row text-center">
				<div class="tip">按顺序完成操作即可贷款</div>
			</div>
			<div class="row">
				<ul class="list-group">
					<li class="list-group-item">
						<div class="row">
							<div class="col-xs-8">
								<img src="../../static/img/2@1.5x.png" /><span>身份认证</span>
							</div>
							<div class="col-xs-4">
								<div class="pull-right">
									<div v-if="step<=0">
										<template v-if="step==0">
											<a href="#/step0">
												<button class="btn btn-sm gotoactive">去认证</button>
											</a>
										</template>
										<template v-else>
											<button class="btn btn-sm">待认证</button>
										</template>
									</div>
									<div v-else>
										<span>已认证</span>
									</div>
								</div>
							</div>
						</div>

						<hr />
						<span>填写身份真实信息可提高您的借款额度</span>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-xs-8">
								<img src="../../static/img/1@1.5x.png" /><span>肖像认证</span>
							</div>
							<div class="col-xs-4">
								<div class="pull-right">
									<div v-if="step<=1">
										<template v-if="step==1">
											<a href="#/step1">
												<button class="btn btn-sm gotoactive">去认证</button>
											</a>
										</template>
										<template v-else>
											<button class="btn btn-sm">待认证</button>
										</template>
									</div>
									<div v-else>
										<span>已认证</span>
									</div>
								</div>
							</div>
						</div>

						<hr />
						<span>将您的肖像与身份证对比、确保为本人</span>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-xs-8">
								<img src="../../static/img/3@1.5x.png" /><span>身份认证</span>
							</div>
							<div class="col-xs-4">
								<div class="pull-right">
									<div v-if="step<=2">
										<template v-if="step==2">
											<a href="#/step2">
												<button class="btn btn-sm gotoactive">去认证</button>
											</a>
										</template>
										<template v-else>
											<button class="btn btn-sm">待认证</button>
										</template>
									</div>
									<div v-else>
										<span>已认证</span>
									</div>
								</div>
							</div>
						</div>

						<hr />
						<span>运营商服务账号认证</span>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-xs-8">
								<img src="../../static/img/4@1.5x.png" /><span>身份认证</span>
							</div>
							<div class="col-xs-4">
								<div class="pull-right">
									<div v-if="step<=3">
										<template v-if="step==3">
											<a href="#/step3">
												<button class="btn btn-sm gotoactive">去认证</button>
											</a>
										</template>
										<template v-else>
											<button class="btn btn-sm">待认证</button>
										</template>
									</div>
									<div v-else>
										<span>已认证</span>
									</div>
								</div>
							</div>
						</div>

						<hr />
						<span>芝麻分认证</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: "Home",
		data() {
			return {
				step: 1
			}
		},
		methods: {}
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
	.headcom .num .col-xs-3 div{
		
		display: inline-block;
		width: 20px;
		height: 20px;
		line-height: 20px;
		border-radius: 100%;
		color: #4F72ED;
		background-color: #FFFFFF;
	}
	.home {
		background-color: #F4F5F9;
		padding-bottom: 20%;
	}
	
	.list-group img {
		width: 50px;
	}
	
	.list-group .list-group-item {
		border: 0px;
		border-radius: 10px;
		margin-left: 8%;
		margin-right: 8%;
		margin-bottom: 15px;
	}
	
	.tip {
		margin: 15px;
	}
	
	.gotoactive {
		background-color: #5A8CF9;
	}
	
	.list-group .list-group-item button {
		color: #FFFFFF;
		border-radius: 20px;
		margin: 10px;
	}
	
	.list-group-item>span {
		color: #CCCCCC;
	}
	
	.list-group-item .row span {
		color: #5A8DF9;
		line-height: 50px;
	}
</style>